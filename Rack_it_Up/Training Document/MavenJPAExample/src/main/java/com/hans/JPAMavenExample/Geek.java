package com.hans.JPAMavenExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "GEEK")
@Table(name = "JPA_GEEK")
public class Geek extends Person {

	@Column(name = "G_FAV_LANG")
	private String favLanguage;

	/**
	 * @return the favLanguage
	 */
	public String getFavLanguage() {
		return favLanguage;
	}

	/**
	 * @param favLanguage the favLanguage to set
	 */
	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}
}
