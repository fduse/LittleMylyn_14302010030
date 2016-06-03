package com.littlemylyn.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.biz.impl.TaskBiz;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskType;

public class TaskBizTest {
	private TaskBiz tBiz;
	
	@Before
	public void setUp() throws Exception {
		tBiz = new TaskBiz();
	}

	@Test
	public void testTaskBiz() {
		System.out.println(tBiz.toString());
	}
	
	@Test
	public void testgetAllTask() {
		System.out.println(tBiz.getAllTask().toString());
	}
	
	@Test
	public void testaddTask() {
		Assert.assertEquals(false, tBiz.addTask(new Task("ooo", TaskType.Feature)));
		Assert.assertEquals(true, tBiz.addTask(new Task("oo1", TaskType.Feature)));	
	}
	@Test
	public void testsearchTask() {
		System.out.println(tBiz.searchTask("nnn"));
	}
	@Test
	public void testrmTask() {
		Assert.assertEquals(false, tBiz.rmTask(new Task("asd", TaskType.Feature)));
		Assert.assertEquals(true, tBiz.rmTask(new Task("oo", TaskType.Feature)));
	}
	@Test
	public void testupdateTask() {
		Assert.assertEquals(false, tBiz.updateTask(new Task("asd", TaskType.Feature)));
		Assert.assertEquals(true, tBiz.updateTask(new Task("ooo", TaskType.Feature)));
	}

}
