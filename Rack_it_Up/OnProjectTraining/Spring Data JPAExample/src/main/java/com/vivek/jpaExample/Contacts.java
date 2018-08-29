package com.vivek.jpaExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CONTACTS_VIVEK")
public class Contacts {
	
	@Id
	@SequenceGenerator(name = "CONTACTSEQUENCEID", sequenceName = "CONTACTSEQUENCE")
	@GeneratedValue(generator = "CONTACTSEQUENCEID")
	@Column(name="CONTACT_ID")
	private Long contactId;
	
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID", foreignKey=@ForeignKey(name="EMPLOYEE_ID_FK"))
	private Employee employee;
	
	

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
