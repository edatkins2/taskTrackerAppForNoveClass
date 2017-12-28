package com.oosdclass.taskTrackerApp2.model;

public class Task {
	
	private int taskId;
	private String description;
	private String assignedTo;
	private String status;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int id) {
		this.taskId = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
