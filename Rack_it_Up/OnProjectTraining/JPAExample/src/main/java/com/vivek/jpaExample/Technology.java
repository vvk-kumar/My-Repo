package com.vivek.jpaExample;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TECHNOLOGY")
public class Technology {
	
	
	@Id
	@SequenceGenerator(name = "TECHNOLOGYSEQUENCEID", sequenceName = "TECHNOLOGYSEQUENCE")
	@GeneratedValue(generator = "TECHNOLOGYSEQUENCEID")
	@Column(name="TECHNOLOGY_ID")
	private Long techId;
	
	@Column(name="TECHNOLOGY_NAME")
	private String technologyName;
	
	@ManyToMany(mappedBy="techList", fetch=FetchType.LAZY)
	private List<Employee> empList;

	public Long getTechId() {
		return techId;
	}

	public void setTechId(Long techId) {
		this.techId = techId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	
}
