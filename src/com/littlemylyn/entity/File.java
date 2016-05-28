package com.littlemylyn.entity;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

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
		//System.out.println(((IFileEditorInput)path).getFile().getFullPath().toString());
	}
	
	public File(String name, String path) {
		this.name = name;
		IPath ipath = new Path(path);
		IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(ipath);
		this.file = new FileEditorInput(ifile);		
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

	public String toString() {
		String name = this.name;
		String path = ((IFileEditorInput)file).getFile().getFullPath().toString();
		//TODO
		return null;
	}
}
