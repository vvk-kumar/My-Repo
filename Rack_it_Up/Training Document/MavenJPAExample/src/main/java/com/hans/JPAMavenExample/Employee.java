package com.hans.JPAMavenExample;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="H_EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	@SequenceGenerator(name = "EMPLOYEESEQUENCEID", sequenceName = "H_SQ_EMPLOYEE_ID")
	@GeneratedValue(generator = "EMPLOYEESEQUENCEID")
	private Long id;
	@Embedded
	@AttributeOverrides(value={@AttributeOverride(name="firstName", column=@Column(name="FIRST_NAME")),
		@AttributeOverride(name="lastName", column=@Column(name="LASTS_NAME"))})
	private PersnolInformation persnolInformation;
	@OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="EMP_IDC_ID", foreignKey = @ForeignKey(name = "EMP_IDC_ID_FK"))
	private IDCard idCard;
	@OneToMany(mappedBy="employee", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Phone> phoneNumbers;
	 
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the idCard
	 */
	public IDCard getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the persnolInformation
	 */
	public PersnolInformation getPersnolInformation() {
		return persnolInformation;
	}
	/**
	 * @param persnolInformation the persnolInformation to set
	 */
	public void setPersnolInformation(PersnolInformation persnolInformation) {
		this.persnolInformation = persnolInformation;
	}
	/**
	 * @return the phoneNumbers
	 */
	public List<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}
	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(List<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}
