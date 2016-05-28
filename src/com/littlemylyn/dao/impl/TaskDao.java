package com.littlemylyn.dao.impl;

import java.util.List;

import com.littlemylyn.dao.TaskDaoIF;
import com.littlemylyn.entity.Task;
import com.littlemylyn.util.DBUtil;

/**
 * @author duocai
 * @date 2016年5月25日 下午4:44:54
 */
public class TaskDao implements TaskDaoIF {
	private DBUtil dbUtil;
	/**
	 * 
	 * 2016年5月25日 下午4:44:54
	 */
	public TaskDao() {
		dbUtil = new DBUtil();
	}

	@Override
	public void addTask(Task arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rmTask(Task arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task searchTask(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTask(Task arg0) {
		// TODO Auto-generated method stub
		
	}

}
