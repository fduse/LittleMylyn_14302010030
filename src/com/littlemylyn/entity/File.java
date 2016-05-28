package com.littlemylyn.entity;

/**
 * @author duocai
 * @date 2016年5月27日 下午6:05:15
 */
public class File {
	private String name;
	private String path;
	
	/**
	 * 
	 * 2016年5月27日 下午6:05:15
	 */
	public File(String name, String path) {
		this.name = name;
		this.path = path;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public String getPath() {
		return path;
	}
}
