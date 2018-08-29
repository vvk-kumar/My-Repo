package it.sella.boundry.beans;

import it.sella.student.interfaces.AbstractStudent;

public class StudentRequestBean extends AbstractStudent{

	Integer age;
	Integer id;
	String name;
	String gender;
	String classandsec;
	String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassandsec() {
		return classandsec;
	}
	public void setClassandsec(String classandsec) {
		this.classandsec = classandsec;
	}
	@Override
	public String toString() {
		
		return name+" "+id+" "+age+" "+gender+" "+classandsec;
	}
	
	
}
