package com.littlemylyn.test;

import static org.junit.Assert.*;

import org.eclipse.ui.IFileEditorInput;
import org.junit.Before;
import org.junit.Test;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.biz.impl.TaskBiz;
import com.littlemylyn.util.DBUtil;

public class TaskBizTest {
	private TaskBizIF tBizIF;
	
	@Before
	public void setUp() throws Exception {
		tBizIF = new TaskBiz();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
