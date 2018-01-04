package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	
	@RequestMapping(value="/adminTasks")
	public ModelAndView viewAdminTasks(ModelAndView model) {
		
		//replace the mock method with the service
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("adminTasks");
		return model;
		//set this for adminTasks.jsp
	}
	
	@RequestMapping(value="/empTasks/{username}")
	public ModelAndView viewEmpTasks(ModelAndView model, @PathVariable String username) {
		
		//replace the mock method with the service
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.addObject(username);
		model.setViewName("empTasks");
		return model;
		//set this for empTask.jsp
	}
	
	
	//GET: show the admin only "create task" form
		@RequestMapping(value="/createTaskForm") 
		public ModelAndView createTaskForm(ModelAndView model) {	
			//map create task form in the view page
			Task task = new Task();
			model.addObject(task);
			model.setViewName("createTask");
			return model;
		}
		//POST: post the newly created task to the DAO, and then display the updated table in "view task" page
		@RequestMapping(value="/createTask", method = RequestMethod.POST)
		public ModelAndView createTask(Task task) {
			ModelAndView model=null;
			taskService.saveTask(task); 
			model = new ModelAndView("redirect:/adminTasks");
			return model;
		}	
		//GET: show the employee-only "update task" form
		@RequestMapping(value="/viewTask/{taskID}/{username}") 
		public ModelAndView viewTask(ModelAndView model, @PathVariable int taskID, @PathVariable String username) {	
			Task task = taskService.getTaskById(taskID);
			model.addObject(task);
			model.addObject(username);
			model.setViewName("viewTask");
			return model;
		}
		
		//attempts are being made to create a new viewpage/method for each button
		//BUTTON: ASSIGN TO ME
		@RequestMapping(value="/updateTask/{status}/{taskID}/{username}", method = RequestMethod.GET)
		public ModelAndView updateStatus(@PathVariable int taskID, @PathVariable String status, @PathVariable String username) {
			ModelAndView model=null;
			taskService.updateStatus(taskID, status);
			model = new ModelAndView("redirect:/empTasks/{username}");
			return model;
		}	
		@RequestMapping(value="/updateTask/ASSIGN/{taskID}/{username}", method = RequestMethod.GET)
		public ModelAndView updateAssignedTo(@PathVariable int taskID, @PathVariable String username) {
			ModelAndView model=null;
			taskService.updateAssignedTo(taskID, username);
			model = new ModelAndView("redirect:/empTasks/{username}");
			return model;
		}
		
		
	}
