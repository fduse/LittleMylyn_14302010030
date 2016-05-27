package com.littlemylyn.view.tree;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午8:00:32
 */
public class StatusLeafObject extends TreeObject {

	/**
	 * @param task
	 * @param name
	 * 2016年5月27日 下午8:00:32
	 */
	public StatusLeafObject(Task task, String name) {
		super(task, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * get status images 
	 */
	@Override
	public Image getImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}

	@Override
	//TODO
	public void doubleClick(TreeViewer viewer) {
		MessageDialog.openInformation(
				viewer.getControl().getShell(),
				"Task View",
				"not implement change status yet");
	}

}
