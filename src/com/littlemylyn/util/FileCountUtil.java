package com.littlemylyn.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import org.eclipse.core.runtime.IPath;

import com.littlemylyn.entity.File;

public class FileCountUtil {
	
	private IWorkbenchWindow window;
	private IWorkbenchPage page;
	private IPartListener listener;
	private List<IEditorInput> fileOpened;
	private boolean isStarted = false;

	public FileCountUtil() {
		// init page
		window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		page = window.getActivePage();
		// init listener
		listener = new IPartListener() {
			@Override
			public void partActivated(IWorkbenchPart arg0) {}
			@Override
			public void partBroughtToTop(IWorkbenchPart arg0) {}
			@Override
			public void partClosed(IWorkbenchPart arg0) {}
			@Override
			public void partDeactivated(IWorkbenchPart arg0) {}

			@Override
			public void partOpened(IWorkbenchPart arg0) {
				if (arg0 instanceof IEditorPart) {
					IEditorInput file = ((IEditorPart) arg0).getEditorInput();
					if (fileOpened.contains(file)) return;
					fileOpened.add(file);
				}
			}			
		};
		// init collection
		fileOpened = new ArrayList<>();
	}
	
	public void start() {
		if (isStarted) {
			MessageDialog.openInformation(
					window.getShell(),
					"LittleMyLyn",
					"Already started!");
		} else {
			fileOpened.clear();
			page.addPartListener(listener);
			isStarted = true;
		}
	}
	
	public List<File> finish() {
		if (isStarted) {
			page.removePartListener(listener);
			isStarted = false;
			return toFileList(fileOpened);
		} else {
			MessageDialog.openInformation(
					window.getShell(),
					"LittleMyLyn",
					"Not started!");
			return null;
		}
	}
	
	private List<File> toFileList(List<IEditorInput> list) {
		List<File> lf = new ArrayList<>();
		list.forEach(e -> {
			String name = e.getName();
			lf.add(new File(name, e));
		});
		return lf;
	}

	public boolean getStarted() {
		return isStarted;
	}
}
