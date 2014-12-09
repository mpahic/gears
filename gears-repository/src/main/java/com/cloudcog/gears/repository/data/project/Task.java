package com.cloudcog.gears.repository.data.project;

import com.cloudcog.gears.repository.data.Versionable;

public class Task extends Versionable {
	private String taskName;
	private Integer taskDuration;
	private Duration taskDurationMetrics;
	private String asignee;
	private String agigneeName;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getTaskDuration() {
		return taskDuration;
	}
	public void setTaskDuration(Integer taskDuration) {
		this.taskDuration = taskDuration;
	}
	public Duration getTaskDurationMetrics() {
		return taskDurationMetrics;
	}
	public void setTaskDurationMetrics(Duration taskDurationMetrics) {
		this.taskDurationMetrics = taskDurationMetrics;
	}
	public String getAsignee() {
		return asignee;
	}
	public void setAsignee(String asignee) {
		this.asignee = asignee;
	}
	public String getAgigneeName() {
		return agigneeName;
	}
	public void setAgigneeName(String agigneeName) {
		this.agigneeName = agigneeName;
	}
	
}
