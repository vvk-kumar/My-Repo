package com.vivek.jpaSpecs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class UserSpecs implements Specification<Userspec> {

	private Userspec filter;

	public UserSpecs(Userspec filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Userspec> root, CriteriaQuery<?> cq,
			CriteriaBuilder cb) {

		Predicate p = cb.disjunction();
		Predicate previousValue = null;

		if (filter.getFirstName() != null) {
			
			previousValue = cb.or(
					cb.equal(root.get("lastName"), filter.getLastName()),
					cb.equal(root.get("lastName"), "RR"));
			
		}

		if (filter.getAge() != null) {
			p.getExpressions().add(
					cb.and(cb.greaterThanOrEqualTo(root.<Integer>get("age"), 24),
							previousValue));
		}
		
		String[] conditions = {"END", "STRAT", "NOTEQUAL"};
		
		Predicate pv = null;
		Predicate cv = null;
		
		for(String condition : conditions) {
			switch (condition) {
			case "END":
				cv = cb.like(root.<String>get("lastName"), "sas");
				
				break;

			default:
				break;
			}
			if(condition == "OR") {
				cv = cb.or(pv, cv);
			} else if(condition == "AND") {
				cv = cb.and(pv, cv);
			}
			pv = cv;
		}

		return p;

	}

}
