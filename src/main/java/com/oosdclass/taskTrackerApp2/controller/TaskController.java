package com.oosdclass.taskTrackerApp2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.model.User;

@Controller
public class TaskController {

	//When TaskService is ready
	//@Autowire
	
	@RequestMapping(value="/adminTasks")
	public ModelAndView viewTask(ModelAndView model) {
		
List<Task> taskList = mockServiceTasks():
	model.addObject(taskList);
model.setViewName("viewTask");
return model;
}
	
	
	public List<Task> mockServiceTaks() {
		Task task1 = new Task();
		Task task2 = new Task();
		
		task1.setId(1);
		task1.setTaskDescription("taskDescription");
		task1.setStatus("Open");
		task2.setAssignedTo("assignedTo");
		
		List<Task> tasklList = new ArrayList<Task>();
		tasklList.add(task1);
		tasklList.add(task2);
		
		return tasklList;
	}
	
	}
