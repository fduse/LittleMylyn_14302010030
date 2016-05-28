package com.littlemylyn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duocai
 * @date 2016年5月25日 下午4:30:03
 */
public class Task {
	private String name;
	private TaskType type;
	private TaskStatus status;
	private List<File> files = new ArrayList<>();
	
	/**
	 * 
	 * 2016年5月25日 下午4:30:03
	 */
	public Task(String name, TaskType type, TaskStatus status) {
		this.name = name;
		this.type = type;
		this.status = status;
	}
	
	/**
	 * 
	 * 2016年5月28日 下午4:30:03
	 */
	public Task(String name, TaskType type) {
		this.name = name;
		this.type = type;
		this.status = TaskStatus.New;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	
	public void addFile(File file) {
		files.add(file);
	}
	
	/**
	 * 
	 * @param file
	 * @return 
	 * returns true if this list contained the specified element 
	 * else return false
	 * 2016年5月27日 下午6:14:08
	 */
	public boolean rmFile(File file) {
		return files.remove(file);
	}
	
	/**
	 * i should between 0 and files.size
	 * @param i
	 * @return
	 * 2016年5月27日 下午6:16:53
	 */
	public File getFile(int i) {
		return files.get(i);
	}
	
	public int getFilesSize() {
		return files.size();
	}
}
