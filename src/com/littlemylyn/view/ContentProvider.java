package com.littlemylyn.view;


import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.entity.Task;
import com.littlemylyn.view.tree.DefaultLeafObject;
import com.littlemylyn.view.tree.FileLeafObject;
import com.littlemylyn.view.tree.FolderParentObject;
import com.littlemylyn.view.tree.ParentObject;
import com.littlemylyn.view.tree.StatusLeafObject;
import com.littlemylyn.view.tree.TreeObject;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:11:11
 */
public class ContentProvider implements IStructuredContentProvider, ITreeContentProvider {

	private ParentObject invisibleRoot;
	private TaskBizIF taskBizIF;
	TaskView view;
	
	/**
	 * 
	 * 2016年5月27日 下午7:11:11
	 */
	public ContentProvider(TaskBizIF taskBizIF,TaskView view) {
		this.taskBizIF = taskBizIF;
		this.view = view;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	public void dispose() {
	}
	public Object[] getElements(Object parent) {
		if (parent.equals(view.getViewSite())) {
			initialize();
			return getChildren(invisibleRoot);
		}
		return getChildren(parent);
	}
	public Object getParent(Object child) {
		if (child instanceof TreeObject) {
			return ((TreeObject)child).getParent();
		}
		return null;
	}
	public Object [] getChildren(Object parent) {
		if (parent instanceof ParentObject) {
			return ((ParentObject)parent).getChildren();
		}
		return new Object[0];
	}
	public boolean hasChildren(Object parent) {
		if (parent instanceof ParentObject)
			return ((ParentObject)parent).hasChildren();
		return false;
	}
	
	/**
	* We will set up a dummy model to initialize tree heararchy.
	* In a real code, you will connect to a real model and
	* expose its hierarchy.
	*/
	private void initialize() {
		List<Task> tasks = taskBizIF.getAllTask();
		invisibleRoot = new FolderParentObject(null, "");
		for (Task task : tasks) {
			TreeObject type = new DefaultLeafObject(task, task.getType().name());
			TreeObject status = new StatusLeafObject(task,task.getStatus().name());
			ParentObject files = new FolderParentObject(task, "Related Files");
			int fileSize = task.getFilesSize();
			for (int i = 0; i < fileSize; i++) {
				files.addChild(new FileLeafObject(task, task.getFile(i).getName()));
			}
			
			ParentObject taskFolder = new FolderParentObject(task, task.getName());
			taskFolder.addChild(type);
			taskFolder.addChild(status);
			taskFolder.addChild(files);
			
			invisibleRoot.addChild(taskFolder);
		}
	}

}
