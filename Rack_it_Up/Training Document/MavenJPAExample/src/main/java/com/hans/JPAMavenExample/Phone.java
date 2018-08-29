package com.hans.JPAMavenExample;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="H_PHONE")
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PH_ID")
	private Long id;
	@Column(name="PH_MOBILE_NUMBER")
	private String mobileNumber;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="PH_EMP_ID", foreignKey=@ForeignKey(name="PH_EMP_ID_FK"))
	private Employee employee;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
