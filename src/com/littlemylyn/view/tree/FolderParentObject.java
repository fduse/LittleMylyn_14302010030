package com.littlemylyn.view.tree;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.entity.Task;

/**
 * @author duocai
 * @date 2016年5月27日 下午8:03:05
 */
public class FolderParentObject extends ParentObject {

	/**
	 * @param task
	 * @param name
	 * 2016年5月27日 下午8:03:05
	 */
	public FolderParentObject(Task task, String name) {
		super(task, name);
	}

	/**
	 * get folder image
	 */
	@Override
	public Image getImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
	}

}
