package it.sella.hypehub.core.marketingdashboard;

import it.sella.hypehub.marketingdashboard.HypeMarketingDashboardException;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardColumnFilters;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardErrorCode;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardFilters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MarketingDashboardSpecificationBuilder {
	
	private static final Logger log = Logger.getLogger(MarketingDashboardSpecificationBuilder.class);
		
	public <T> Predicate getConsumerSpecification(final Root<T> root, final CriteriaBuilder cb,final List<MarketingDashboardColumnFilters> magnewsList) throws ParseException{
		Predicate finalSpec = cb.conjunction();
		int predicateFlag = 0;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		if(magnewsList == null){
			//finalSpec = cb.disjunction();
			return finalSpec;
		}
		for(MarketingDashboardColumnFilters magnewsColumns: magnewsList){
			
			Predicate p = null;
			Predicate cv = null;
			
			ArrayList<MarketingDashboardFilters> magnewsFilter = magnewsColumns.getFilterList();
			
			for(MarketingDashboardFilters appliedFilter: magnewsFilter){
				
				Expression<String> path = root.get(magnewsColumns.getName());
				Class<? extends Object> javaType = path.getJavaType();
				String value = appliedFilter.getValue();
				
				switch (appliedFilter.getConstrain()) {
					case "EQUAL_TO":
						//Object oValue = javaType.getName()		
						 if("Date".equalsIgnoreCase(javaType.getSimpleName())){
							 cv = cb.equal(root.<Date>get(magnewsColumns.getName()),  dateFormat.parse(appliedFilter.getValue()));
						 }
						 else if("Long".equalsIgnoreCase(javaType.getSimpleName())){
							 cv = cb.equal(root.<Long>get(magnewsColumns.getName()), appliedFilter.getValue());
						 }
						 else{
							 cv = cb.equal(cb.upper(path), value.toUpperCase());
						 }
						break;
					case "DIFFERENT_THAN":
						if("Date".equalsIgnoreCase(javaType.getSimpleName())){
							 cv = cb.notEqual(root.<Date>get(magnewsColumns.getName()),  dateFormat.parse(appliedFilter.getValue()));
						}
						else if("Long".equalsIgnoreCase(javaType.getSimpleName())){
							cv = cb.notEqual(root.<Long>get(magnewsColumns.getName()),  appliedFilter.getValue());
						}
						else{
							cv = cb.notEqual(cb.upper(path), value.toUpperCase());
						}
						break;
					case "STARTS_WITH":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.like(cb.upper(root.<String>get(magnewsColumns.getName())), value.toUpperCase().concat("%"));
						break;
					case "DOES_NOT_START_WITH":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.notLike(cb.upper(root.<String>get(magnewsColumns.getName())), value.toUpperCase().concat("%"));
						break;
					case "ENDS_WITH":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.like(cb.upper(root.<String>get(magnewsColumns.getName())), "%".concat(value).toUpperCase());
						break;
					case "DOES_NOT_END_WITH":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.notLike(cb.upper(root.<String>get(magnewsColumns.getName())), "%".concat(value).toUpperCase());
						break;
					case "CONTAINS":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.like(cb.upper(root.<String>get(magnewsColumns.getName())), "%".concat(value).toUpperCase().concat("%"));
						break;
					case "DOES_NOT_CONTAIN":
						checkColoumnTypeString(magnewsColumns.getName(), javaType);
						cv = cb.notLike(cb.upper(root.<String>get(magnewsColumns.getName())), "%".concat(value).toUpperCase().concat("%"));
						break;
					case "IS_GRATER_THEN":
						if("Long".equalsIgnoreCase(javaType.getSimpleName())){
							cv = cb.greaterThan(root.<Long>get(magnewsColumns.getName()), new Long(appliedFilter.getValue()));
						}
						else if("Date".equalsIgnoreCase(javaType.getSimpleName())){
							
							try {
								cv = cb.greaterThan(root.<Date>get(magnewsColumns.getName()),  dateFormat.parse(appliedFilter.getValue()));
							} catch (ParseException e) {
								log.debug("MarketingDashboardSpecificationBuilder--> getConsumerSpecification --> Filter Column Error : " + magnewsColumns.getName());
								throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,magnewsColumns.getName());
							}
						}
						else{
							log.debug("MarketingDashboardSpecificationBuilder--> getConsumerSpecification --> Filter Column Error : " + magnewsColumns.getName());
							throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,magnewsColumns.getName());
						}
						
						break;
					case "IS_LOWER_THAN":
						if("Long".equalsIgnoreCase(javaType.getSimpleName())){
							cv = cb.lessThan(root.<Long>get(magnewsColumns.getName()), new Long(appliedFilter.getValue()));
						}
						else if("Date".equalsIgnoreCase(javaType.getSimpleName())){
							try {
								cv = cb.lessThan(root.<Date>get(magnewsColumns.getName()), dateFormat.parse(appliedFilter.getValue()));
							} catch (ParseException e) {
								log.debug("MarketingDashboardSpecificationBuilder--> getConsumerSpecification --> Filter Column Error : " + magnewsColumns.getName());
								throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,magnewsColumns.getName());
							}
						}
						else{
							log.debug("MarketingDashboardSpecificationBuilder--> getConsumerSpecification --> Filter Column Error : " + magnewsColumns.getName());
							throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,magnewsColumns.getName());
						}
						break;
					default:
						break;
				}
				
				if(appliedFilter.getConjunction() == null && p != null) {
					throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,"No Conjunction Found");
				}
				
				if("OR".equalsIgnoreCase(appliedFilter.getConjunction())) {
					cv = cb.or(p, cv);
				} else if("AND".equalsIgnoreCase(appliedFilter.getConjunction())) {
					cv = cb.and(p, cv);
				}
				p = cv;
			}
			if(predicateFlag == 0){
				finalSpec = p;
			}
			else{
				finalSpec = cb.and(finalSpec, p);
			}
			predicateFlag++;
		}
		
		return finalSpec;
	}

	private void checkColoumnTypeString(String coloumnName, Class<? extends Object> javaType) {
		if(!"String".equalsIgnoreCase(javaType.getSimpleName())){
			throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.INVALID_DATA,"INVALID COLUMN TYPE");
		}
	}
}
