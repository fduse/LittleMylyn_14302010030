package com.littlemylyn.entity;

import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author duocai
 * @date 2016年5月27日 下午6:05:15
 */
public class File {
	private String name;
	private IEditorInput file;
	
	/**
	 * 
	 * 2016年5月27日 下午6:05:15
	 */
	public File(String name, IEditorInput path) {
		this.name = name;
		this.file = path;
	}
	
	public void open() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(name);
		try {
			page.openEditor(file, desc.getId());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getName() {
		return name;
	}

}
