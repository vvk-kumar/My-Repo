package it.sella.student.interfaces;

public enum ClassPathEnum {
	
	CORE("it.sella.student.core.Core");

	private String path;

	private ClassPathEnum(String path){
		this.path=path;
	}

	public String getPath() {
		return path;
	}
}
