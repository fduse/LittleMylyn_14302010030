package com.littlemylyn.view;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.littlemylyn.biz.TaskBizIF;
import com.littlemylyn.biz.impl.TaskBiz;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskType;



/**
 * @author duocai
 * @date 2016年5月28日 上午10:06:33
 */
public class NewTaskWisard extends Wizard implements INewWizard{
	private NewTaskPage page;
	private TaskBizIF taskBizIF;
	
	/**
	 * 
	 * 2016年5月28日 上午10:06:33
	 */
	public NewTaskWisard() {
		
	}

	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		taskBizIF = new TaskBiz();
	}
	
	/**
	 * Adding the page to the wizard.
	 */
	@Override
	public void addPages() {
		page = new NewTaskPage(taskBizIF);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String taskName = page.getTaskName();
		final String taskType = page.getTaskType();
		Task task = new Task(taskName, getType(taskType));
		if (!taskBizIF.addTask(task)) {
			MessageDialog.openInformation(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"LittleMyLyn",
					"Task is already existed!");
		}
		TaskView.refresh();
		return true;
	}
	
	//TODO not proper
	private TaskType getType(String type) {
		switch (type) {
		case "debug":
			return TaskType.Debug;
		case "new feature":
			return TaskType.Feature;
		case "refactor":
			return TaskType.Refactor;
		default:
			return null;
		}
	}
}
