package com.littlemylyn.handlers;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

import com.littlemylyn.entity.File;
import com.littlemylyn.util.FileCountUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class WelcomeHandler extends AbstractHandler {
	
	FileCountUtil fc;
	/**
	 * The constructor.
	 */
	public WelcomeHandler() {
		fc = FileCountUtil.getInstance();
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		if (fc.getStarted()) {
			List<File> ss = fc.finish();
			ss.forEach(System.out::println);
		} else {
			fc.start();
		}
		
		MessageDialog.openInformation(
				window.getShell(),
				"LittleMyLyn",
				"Hello, Eclipse world");
		return null;
	}
}
