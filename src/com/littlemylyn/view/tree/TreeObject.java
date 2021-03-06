package com.littlemylyn.view.tree;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:06:39
 */
public abstract class TreeObject implements IAdaptable {
	
	private ParentObject parent;
	protected Task task;
	private String name;
	
	/**
	 * 
	 * 2016年5月27日 下午7:06:39
	 */
	public TreeObject(Task task, String name) {
		this.task = task;
		this.name = name;
	}
	
	public abstract Image getImage();
	public abstract void doubleClick(TreeViewer viewer);
	
	@Override
	public String toString() {
		return name;
	}
	
	public void setParent(ParentObject parentObject) {
		this.parent = parentObject;
	}
	
	public ParentObject getParent() {
		return parent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class arg0) {
		return null;
	}
}
