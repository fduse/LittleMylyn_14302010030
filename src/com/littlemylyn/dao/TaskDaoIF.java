package com.littlemylyn.dao;

import java.util.List;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月25日 下午4:40:10
 */
public interface TaskDaoIF {
	/**
	 * get all tasks
	 * @return
	 * 2016年5月28日 上午9:36:10
	 */
	public List<Task> getAllTask();//
	
	/**
	 * add new task
	 * @param task
	 * 2016年5月28日 上午9:36:24
	 */
	public void addTask(Task task);//
	
	/**
	 * remove the parameter task
	 * the task should exist
	 * @param task
	 * 2016年5月28日 上午9:37:25
	 */
	public void rmTask(Task task);
	
	/**
	 * update the task
	 * the task should exist
	 * @param task
	 * 2016年5月28日 上午9:39:01
	 */
	public void updateTask(Task task);
	
	/**
	 * search the task by key name
	 * @param name
	 * @return
	 * 	task if exist
	 *  else null
	 * 2016年5月28日 上午9:40:26
	 */
	public Task searchTask(String name);
}
