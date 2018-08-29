package it.sella.hypehub.core.marketingdashboard;

import it.sella.hypehub.marketingdashboard.HypeMarketingDashboardException;
import it.sella.hypehub.marketingdashboard.IMarketingDashboardDAO;
import it.sella.hypehub.persistence.marketingdashboard.MarketingDashboardAccountData;
import it.sella.hypehub.persistence.marketingdashboard.MarketingDashboardAppData;
import it.sella.hypehub.persistence.marketingdashboard.MarketingDashboardTransactionData;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardColumnFilters;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardDataList;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardErrorCode;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardRequest;
import it.sella.hypehub.types.marketingdashboard.MarketingDashboardTableFilter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MarketingDashboardDAO implements IMarketingDashboardDAO {
	

	MarketingDashboardSpecificationBuilder magnewsSpecificationBuilder;
	List<MarketingDashboardDataList> magnewsDataList=null;
	Predicate appPredicate = null;
	Predicate trxPredicate = null;
	Predicate accPredicate = null;
	Long total = null;
	Root<MarketingDashboardAppData> appRoot;
	Root<MarketingDashboardTransactionData> trxRoot;
	Root<MarketingDashboardAccountData> accRoot;
	Page<MarketingDashboardDataList> filteredPage = null;
	@PersistenceContext(unitName="MarketingDashboardPersistenceUnit")
    @Qualifier("marketingDashboard.entityManagerFactory")
	private EntityManager entityManager;
	
	private static final Logger log = Logger.getLogger(MarketingDashboardDAO.class);
	
	@Transactional(readOnly = true)
	public Page<MarketingDashboardDataList> getFilteredTransaction(MarketingDashboardRequest magnewsRequest) {
		
			List<MarketingDashboardTableFilter> magnewsTableFilter  = magnewsRequest.getFilters();
			List<MarketingDashboardColumnFilters> appTableList = null; 
			List<MarketingDashboardColumnFilters> trxTableList = null;
			List<MarketingDashboardColumnFilters> accTableList = null;
			total = magnewsRequest.getCount();
			try {
				
				if(magnewsTableFilter != null){
					for(MarketingDashboardTableFilter tableFilter:magnewsTableFilter){
						String tableName = tableFilter.getTable();
						switch(tableName) {
							case "APP":
								appTableList  = tableFilter.getColumns();
								break;
							case "TXN":
								trxTableList  = tableFilter.getColumns();
								break;
							case "ACC":
								accTableList  = tableFilter.getColumns();
								break;
						}
					}	
				}
				CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
				
				CriteriaQuery<MarketingDashboardDataList> criteriaQuery = criteriaBuilder.createQuery(MarketingDashboardDataList.class);
				appRoot = criteriaQuery.from(MarketingDashboardAppData.class);
				trxRoot = criteriaQuery.from(MarketingDashboardTransactionData.class);
				accRoot = criteriaQuery.from(MarketingDashboardAccountData.class);
				
				appPredicate = magnewsSpecificationBuilder.getConsumerSpecification(appRoot,criteriaBuilder, appTableList); 
				trxPredicate = magnewsSpecificationBuilder.getConsumerSpecification(trxRoot,criteriaBuilder, trxTableList); 
				accPredicate = magnewsSpecificationBuilder.getConsumerSpecification(accRoot,criteriaBuilder, accTableList); 
				
				Predicate filterPredicate = criteriaBuilder.and(criteriaBuilder.equal(accRoot.<Long>get("idSoggetto"), trxRoot.get("idSoggetto")),
						criteriaBuilder.equal(appRoot.<Long>get("idSoggetto"), trxRoot.get("idSoggetto")),
						criteriaBuilder.equal(appRoot.<Long>get("idSoggetto"), accRoot.<Long>get("idSoggetto")),accPredicate,trxPredicate,appPredicate);
				
				if(total == null){
					total = returnCount(criteriaBuilder, criteriaQuery, filterPredicate);
				}
				
				filteredPage = getCriteriaRecords(magnewsRequest, criteriaBuilder, criteriaQuery, filterPredicate);
		
			} catch (final Exception e) {
				log.debug("MarketingDashboardDAO--> getFilteredTransaction --> response : " + filteredPage);
				throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.TECH_SQL_ERROR,"SQL ERROR");
			}
			
			if(filteredPage == null){
				log.debug("MarketingDashboardDAO--> getFilteredTransaction --> No records : " + filteredPage);
				throw new HypeMarketingDashboardException(MarketingDashboardErrorCode.NO_RECORD,"Transaction Not Found");
			}
		
		return filteredPage;
	}
	
	public Long returnCount(CriteriaBuilder criteriaBuilder,CriteriaQuery<MarketingDashboardDataList> criteriaQuery, Predicate filterPredicate){
		criteriaQuery.multiselect(criteriaBuilder.count(accRoot));
		criteriaQuery.where(filterPredicate);
		TypedQuery<MarketingDashboardDataList> typedQueryCount = entityManager.createQuery(criteriaQuery);
		Long count = typedQueryCount.getSingleResult().getCount();
		return count;
	}
	
	public Page<MarketingDashboardDataList> getCriteriaRecords(MarketingDashboardRequest magnewsRequest,CriteriaBuilder criteriaBuilder,CriteriaQuery<MarketingDashboardDataList> criteriaQuery, Predicate filterPredicate){
		
		Page<MarketingDashboardDataList> page = null;
		
		criteriaQuery.multiselect(accRoot, appRoot, trxRoot);
		criteriaQuery.where(filterPredicate);


		Pageable pageRequest = null;
		Integer pageNum = magnewsRequest.getPage();
		Integer offset = magnewsRequest.getOffset();
		if(pageNum != null && offset != null) {
			pageRequest = new PageRequest(pageNum - 1, offset);
		}
				
		Map<String, String> sort = magnewsRequest.getSort();
		if(sort != null) {
			String direction = sort.get("direction");
			String sortColumn = sort.get("column");
			String sortTable = sort.get("table");
			if(sortTable != null && sortColumn != null ) {
				
				Root orderRoot = null;
				switch (sortTable) {
					case "APP":
						orderRoot = appRoot;
						break;
					case "ACC":
						orderRoot = accRoot;
						break;
					case "TXN":
						orderRoot = trxRoot;
						break;
					default:
						break;
				}
				if(orderRoot != null) {
					Direction dir = direction == null ? Direction.ASC : Direction.fromString(direction);
					Path<?> x = orderRoot.get(sortColumn);
					Order order = dir == Direction.ASC ? criteriaBuilder.asc(x) : criteriaBuilder.desc(x);
					criteriaQuery.orderBy(order);
				}
			}
		}
		TypedQuery<MarketingDashboardDataList> typedQuery = entityManager.createQuery(criteriaQuery);
		page = pageRequest == null ? new PageImpl<MarketingDashboardDataList>(typedQuery.getResultList()) : readPage(typedQuery, pageRequest);
		return page;
	}
	
	private Page<MarketingDashboardDataList> readPage(TypedQuery<MarketingDashboardDataList> query, Pageable pageable) {

		query.setFirstResult(pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		List<MarketingDashboardDataList> content = total > pageable.getOffset() ? query.getResultList() : Collections.<MarketingDashboardDataList> emptyList();
		return new PageImpl<MarketingDashboardDataList>(content, pageable, total);
	}

	@Autowired
	public void setMagnewsSpecificationBuilder(MarketingDashboardSpecificationBuilder magnewsSpecificationBuilder) {
		this.magnewsSpecificationBuilder = magnewsSpecificationBuilder;
	}
	
	
}
