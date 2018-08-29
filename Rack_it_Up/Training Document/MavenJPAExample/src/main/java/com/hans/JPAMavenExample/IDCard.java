package com.hans.JPAMavenExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="IDCARD")
public class IDCard {

	@Id
	@SequenceGenerator(name="IDCSEQUENCEID", sequenceName="IDC_SQ_ST_ID")
	@GeneratedValue(generator="IDCSEQUENCEID")
	@Column(name="IDC_ID")
	private Long id;
	@Column(name="IDC_CARD_NUMBER", length=30)
	private String cardNumber;
	@Column(name="IDC_EMP_NUMBER", length=20)
	private String empNumber;
	@OneToOne(mappedBy="idCard")
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
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * @return the empNumber
	 */
	public String getEmpNumber() {
		return empNumber;
	}
	/**
	 * @param empNumber the empNumber to set
	 */
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
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
