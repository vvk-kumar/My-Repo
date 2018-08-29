package com.hans.JPAMavenExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PERSON")
@Table(name = "JPA_PERSON")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@Column(name="P_ID")
	@SequenceGenerator(name = "PERSONSEQUENCEID", sequenceName = "JPA_SQ_MA_PERSON_ID")
	@GeneratedValue(generator = "PERSONSEQUENCEID")
	private Long id;
	@Column(name="P_FIRSTNAME")
	private String firstName;
	@Column(name="P_LASTNAME")
	private String lastName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
