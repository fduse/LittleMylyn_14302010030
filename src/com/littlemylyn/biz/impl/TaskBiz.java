package com.littlemylyn.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.entity.File;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskStatus;
import com.littlemylyn.entity.TaskType;

/**
 * @author duocai
 * @date 2016年5月25日 下午4:44:00
 */
public class TaskBiz implements TaskBizIF {

	/**
	 * 
	 * 2016年5月25日 下午4:44:00
	 */
	public TaskBiz() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * TODO
	 * this is not the real implement at present
	 */
	@Override
	public List<Task> getAllTask() {
		File file = new File("test", "test");
		
		Task task1 = new Task("test1", TaskType.Debug, TaskStatus.New);
		task1.addFile(file);
		Task task2 = new Task("test2", TaskType.Feature, TaskStatus.New);
		task2.addFile(file);
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(task1);
		tasks.add(task2);
		return tasks;
	}

}
