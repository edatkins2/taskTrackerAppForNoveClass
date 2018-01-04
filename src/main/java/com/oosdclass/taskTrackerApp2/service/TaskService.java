package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	
	public List<Task> getAllTask();
	
	public Task getTaskById(int id);
	
	void saveTask(Task task);
	
	void updateStatus(int taskId, String status);
	
	void updateAssignedTo(int taskId, String username);
}
