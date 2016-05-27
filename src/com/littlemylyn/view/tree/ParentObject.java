package com.littlemylyn.view.tree;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.TreeViewer;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:32:50
 */
public abstract class ParentObject extends TreeObject {

	private List<TreeObject> children;
	/**
	 * 
	 * 2016年5月27日 下午7:32:50
	 */
	public ParentObject(Task task, String name) {
		super(task, name);
		children = new ArrayList<>();
	}
	
	public void addChild(TreeObject child) {
		children.add(child);
		child.setParent(this);
	}
	public void removeChild(TreeObject child) {
		children.remove(child);
		child.setParent(null);
	}
	public TreeObject [] getChildren() {
		return (TreeObject [])children.toArray(new TreeObject[children.size()]);
	}
	public boolean hasChildren() {
		return children.size()>0;
	}
	
	@Override
	public void doubleClick(TreeViewer viewer){
		//do nothing
	}
}
