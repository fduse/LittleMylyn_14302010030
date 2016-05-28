package com.littlemylyn.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.dao.TaskDaoIF;
import com.littlemylyn.dao.impl.TaskDao;
import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月25日 下午4:44:00
 */
public class TaskBiz implements TaskBizIF {
	private TaskDaoIF tDaoIF;
	private static List<Task> tasks = new ArrayList<>();
	/**
	 * 
	 * 2016年5月25日 下午4:44:00
	 */
	public TaskBiz() {
		tDaoIF = new TaskDao();
	}

	/**
	 * TODO
	 * this is not the real implement at present
	 */
	@Override
	public List<Task> getAllTask() {
		return tasks;
	}

	@Override
	public void addTask(Task arg0) {
		// TODO Auto-generated method stub
		tasks.add(arg0);
	}

	@Override
	public boolean rmTask(Task arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Task searchTask(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTask(Task arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
