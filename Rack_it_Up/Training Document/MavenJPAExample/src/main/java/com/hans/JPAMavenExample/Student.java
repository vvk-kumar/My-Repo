package com.hans.JPAMavenExample;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="H_STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ST_ID")
	private Long id;
	@Column(name="ST_NAME")
	private String name;
	@Column(name="ST_FATHER_NAME")
	private String fatherName;
	@ElementCollection
	@CollectionTable(name="H_NICKNAMES", joinColumns={@JoinColumn(name="ST_ID", foreignKey=@ForeignKey(name="ST_ID_FK"))})
	@Column(name="NICK_NAME")
	private List<String> nickNames;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}
	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	/**
	 * @return the nickNames
	 */
	public List<String> getNickNames() {
		return nickNames;
	}
	/**
	 * @param nickNames the nickNames to set
	 */
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	
	
}
