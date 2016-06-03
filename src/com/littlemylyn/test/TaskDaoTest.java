package com.littlemylyn.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.littlemylyn.dao.impl.TaskDao;
import com.littlemylyn.entity.File;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskType;

public class TaskDaoTest {
	Task t;
	TaskDao td;
	@Before
	public void setUp() throws Exception {
		t = new Task("nn",TaskType.Feature);
		t.addFile(new File("filename1", "filepath1"));
		t.addFile(new File("filename2", "filepath2"));
		td = new TaskDao();
	}

	@Test
	public void testTaskDao() {
		System.out.println(td.toString());
	}


	@Test
	public void testAddTask() {
		//td.addTask(t);
	}

	@Test
	public void testGetAllTask() {
		List<Task> tasks=td.getAllTask();
		System.out.println(tasks.size());
		for (Task t:tasks){
				System.out.println(t.getName());
				System.out.println(t.getFilesSize());
				System.out.println(t.getStatus());
				System.out.println(t.getType());
				for(int i=0; i<t.getFilesSize(); i++){
					System.out.println(t.getFile(i).getName());
				}
			
		}
	}

	@Test
	public void testRmTask() {
		//td.rmTask(t);
	}

	@Test
	public void testSearchTask() {
		/*Task t2=td.searchTask("ooo");
		if (t2!=null){
			System.out.println(t2.getName());
			System.out.println(t2.getFilesSize());
			System.out.println(t2.getStatus());
			System.out.println(t2.getType());
			System.out.println(t2.getFile(0));
			for(int i=0; i<t2.getFilesSize(); i++){
				System.out.println(t2.getFile(i).getName());
			}
		}*/
	}

	@Test
	public void testUpdateTask() {
		//t.addFile(new File("filename3", "pathname3"));
		//td.updateTask(t);
	}

}
