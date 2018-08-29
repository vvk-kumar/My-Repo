package com.hans.JPAMavenExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class MasterStatus {
	@Id
	@SequenceGenerator(name = "STATUSSEQUENCEID", sequenceName = "UPW_SQ_ST_ID")
	@GeneratedValue(generator = "STATUSSEQUENCEID")
	@Column(name="ST_ID")
	private Long id;
	@Column(name="ST_TYPE")
	private String type;
	@Column(name="ST_DESCRIPTION")
	private String description;
	@Column(name="ST_CODE")
	private String statusCode;
	@Column(name="ST_ENABLED")
	private Integer enabled;
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(final String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(final String description) {
		this.description = description;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(final String statusCode) {
		this.statusCode = statusCode;
	}
	
	public Integer getEnabled() {
		return enabled;
	}
	
	public void setEnabled(final Integer enabled) {
		this.enabled = enabled;
	}
}
