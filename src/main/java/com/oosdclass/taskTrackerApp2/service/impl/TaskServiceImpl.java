package com.oosdclass.taskTrackerApp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDAO taskdao;
	
	@Override
	public List<Task> getAllTask() {
		return taskdao.retrieveAllTasks();	
	}
	
	@Override
	public void saveTask(Task task) {
		task.setStatus("OPEN");
		task.setAssignedTo("UNASSIGNED");
		taskdao.saveTask(task);
	}

	@Override
	public Task getTaskById(int id) {
		return taskdao.retrieveByTaskID(id);
	}

	@Override
	public void updateStatus(int taskId, String status) {
		Task task = taskdao.retrieveByTaskID(taskId);
		task.setStatus(status);
		taskdao.updateTask(task);
		
	}

	@Override
	public void updateAssignedTo(int taskId, String username) {
		Task task = taskdao.retrieveByTaskID(taskId);
		task.setAssignedTo(username);
		taskdao.updateTask(task);
		
		
	}
}
