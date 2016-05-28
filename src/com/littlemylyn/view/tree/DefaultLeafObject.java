package com.littlemylyn.view.tree;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午7:52:24
 */
public class DefaultLeafObject extends TreeObject {

	/**
	 * @param task
	 * @param name
	 * 2016年5月27日 下午7:52:24
	 */
	public DefaultLeafObject(Task task, String name) {
		super(task, name);
	}

	@Override
	public Image getImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}

	@Override
	public void doubleClick(TreeViewer viewer) {
		//do nothing
	}
	
}
