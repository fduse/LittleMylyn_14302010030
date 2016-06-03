package com.littlemylyn.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.entity.File;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskStatus;
import com.littlemylyn.util.FileCountUtil;
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
	private TaskView view;
	private List<Task> tasks = new ArrayList<>();

	/**
	 * 
	 * 2016年5月27日 下午7:11:11
	 */
	public ContentProvider(TaskBizIF taskBizIF, TaskView view) {
		this.taskBizIF = taskBizIF;
		this.view = view;
		PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {
			
			@Override
			public void windowOpened(IWorkbenchWindow arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(IWorkbenchWindow arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(IWorkbenchWindow arg0) {
				for (Task task : tasks) {
					if (task.getStatus() == TaskStatus.Activated) {
						FileCountUtil util = FileCountUtil.getInstance();
						List<File> files = util.finish();
						for (File file : files) {
							if (!task.hasFile(file)) {
								task.addFile(file);
							}
						}
						task.setStatus(TaskStatus.Finished);
						taskBizIF.updateTask(task);
					}
				}
			}
			
			@Override
			public void windowActivated(IWorkbenchWindow arg0) {
				// TODO Auto-generated method stub
				
			}
		});
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
			return ((TreeObject) child).getParent();
		}
		return null;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof ParentObject) {
			return ((ParentObject) parent).getChildren();
		}
		return new Object[0];
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof ParentObject)
			return ((ParentObject) parent).hasChildren();
		return false;
	}

	/**
	 * We will set up a dummy model to initialize tree heararchy. In a real
	 * code, you will connect to a real model and expose its hierarchy.
	 */
	private void initialize() {
		tasks = taskBizIF.getAllTask();
		invisibleRoot = new FolderParentObject(null, "");
		for (Task task : tasks) {
			TreeObject type = new DefaultLeafObject(task, task.getType().name());
			TreeObject status = new StatusLeafObject(task, task.getStatus().name());
			int fileSize = task.getFilesSize();
			ParentObject files = new FolderParentObject(task, "Related Files(" + fileSize + ")");
			for (int i = 0; i < fileSize; i++) {
				files.addChild(new FileLeafObject(task, task.getFile(i).getName(), task.getFile(i)));
			}

			ParentObject taskFolder = new FolderParentObject(task, task.getName());
			taskFolder.addChild(type);
			taskFolder.addChild(status);
			taskFolder.addChild(files);

			invisibleRoot.addChild(taskFolder);
		}
	}
	
}
