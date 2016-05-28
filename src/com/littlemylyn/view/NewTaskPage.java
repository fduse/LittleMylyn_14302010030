package com.littlemylyn.view;


import java.time.temporal.TemporalField;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.littlemylyn.biz.TaskBizIF;

/**
 * @author duocai
 * @date 2016年5月28日 上午10:12:20
 */
public class NewTaskPage extends WizardPage {
	private Text taskNameText;
	private Text taskTypeText;
	private TaskBizIF taskBiz;
	
	/**
	 * 
	 * 2016年5月28日 上午10:12:20
	 */
	public NewTaskPage(TaskBizIF tIf) {
		super("wizardPage");
		setTitle("New task");
		setDescription("This wizard creates a new task.");
		taskBiz = tIf;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		
		Label label = new Label(container, SWT.NULL);
		label.setText("&Task name:");

		taskNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		taskNameText.setLayoutData(gd);
		taskNameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		
		label = new Label(container, SWT.NULL);
		label.setText("&Task type:");
		
		taskTypeText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		taskTypeText.setLayoutData(gd);
		taskTypeText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		taskTypeText.setText("debug");
		

		dialogChanged();
		setControl(container);
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		String taskName = getTaskName();
		String taskType = getTaskType();

		if (taskName.length() == 0) {
			updateStatus("Task name must be specified");
			return;
		}
		if (taskName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("Task name must be valid");
			return;
		}
		
		if (taskBiz.searchTask(taskName) != null) {
			updateStatus("Task is already existed.");
			return;
		}
		
		if (taskType.length() == 0) {
			updateStatus("Task type must be specified");
			return;
		}
		
		if (!(taskType.equals("debug")||taskType.equals("new feature")||taskType.equals("refactor"))){
			updateStatus("Task type must be debug, new feature or refactor");
			return;
		}
		
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getTaskName() {
		return taskNameText.getText();
	}

	public String getTaskType() {
		return taskTypeText.getText();
	}
}
