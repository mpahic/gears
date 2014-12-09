package com.cloudcog.gears.repository.data.project;

public enum Duration {
	HOURS("h"),
	MINUTES("m"),
	DAYS("d");
	
	private String value;
	private Duration(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public String getTranslationValue() {
		//TODO
		return this.value;
	}
}
