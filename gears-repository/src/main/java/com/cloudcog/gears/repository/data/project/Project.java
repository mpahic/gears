package com.cloudcog.gears.repository.data.project;

import java.util.Date;

import com.cloudcog.gears.repository.data.Versionable;


public class Project extends Versionable{

	private String projectName;
	private Integer projectEstimatedDuration;
	private Date projectStartDate;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getProjectEstimatedDuration() {
		return projectEstimatedDuration;
	}
	public void setProjectEstimatedDuration(Integer projectEstimatedDuration) {
		this.projectEstimatedDuration = projectEstimatedDuration;
	}
	public Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
}
