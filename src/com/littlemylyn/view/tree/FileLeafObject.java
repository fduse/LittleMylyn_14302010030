package com.littlemylyn.view.tree;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.File;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:59:05
 */
public class FileLeafObject extends TreeObject {
	private File file;
	
	/**
	 * @param task
	 * @param name
	 * 2016年5月27日 下午7:59:05
	 */
	public FileLeafObject(Task task, String name , File file) {
		super(task, name);
		this.file = file;
	}

	/**
	 * get file image
	 */
	@Override
	public Image getImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
	}

	@Override
	public void doubleClick(TreeViewer viewer) {
		file.open();
	}
}
