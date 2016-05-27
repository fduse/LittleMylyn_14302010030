package com.littlemylyn.view.tree;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:59:05
 */
public class FileLeafObject extends TreeObject {

	/**
	 * @param task
	 * @param name
	 * 2016年5月27日 下午7:59:05
	 */
	public FileLeafObject(Task task, String name) {
		super(task, name);
	}

	/**
	 * get file image
	 */
	@Override
	public Image getImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}

	@Override
	//TODO
	public void doubleClick(TreeViewer viewer) {
		MessageDialog.openInformation(
				viewer.getControl().getShell(),
				"Task View",
				"not implement open file yet");
	}
	
	
}
