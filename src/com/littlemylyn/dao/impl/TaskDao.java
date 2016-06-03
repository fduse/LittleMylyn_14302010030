package com.littlemylyn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.littlemylyn.dao.TaskDaoIF;
import com.littlemylyn.entity.File;
import com.littlemylyn.entity.Task;
import com.littlemylyn.entity.TaskStatus;
import com.littlemylyn.entity.TaskType;
import com.littlemylyn.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author duocai
 * @date 2016年5月25日 下午4:44:54
 */
public class TaskDao implements TaskDaoIF {
	private DBUtil dbUtil;
	/**
	 * 
	 * 2016年5月25日 下午4:44:54
	 */
	public TaskDao() {
		dbUtil = new DBUtil();
	}

	@Override
	public void addTask(Task arg0) {
		Connection conn = dbUtil.getConnection();
		String sql ="INSERT INTO task(type,status,name) VALUES (?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, arg0.getType().name());
			pst.setString(2, arg0.getStatus().name());
			pst.setString(3, arg0.getName());
			
			pst.executeUpdate();
			for(int i=0; i<arg0.getFilesSize(); i++){
				File file=arg0.getFile(i);
				String sql2=String.format("INSERT INTO file(name,path,taskName) VALUES (?,?,?)");
				
				pst = conn.prepareStatement(sql2);
				pst.setString(1, file.getName());
				pst.setString(2, file.getPath());
				pst.setString(3, arg0.getName());
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(null, pst, conn);
		}		
		}

	@Override
	public List<Task> getAllTask() {
		List<Task> tasks=new ArrayList<>();
		Task t = null;
		Connection conn = dbUtil.getConnection();
		String sql = "SELECT * FROM task";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {  // 存在用户
				t = new Task(rs.getString("name"), TaskType.valueOf(rs.getString("type")), TaskStatus.valueOf(rs.getString("status")));
				String sql2="SELECT * FROM file WHERE taskName=?";
				PreparedStatement pst2 = null;
				ResultSet rs2=null;
				pst2 = conn.prepareStatement(sql2);
				pst2.setString(1, rs.getString("name"));
				rs2=pst2.executeQuery();
				while (rs2.next()){
					t.addFile(new File(rs2.getString("name"), rs2.getString("path")));
				}
				tasks.add(t);
				//System.out.println("hit");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pst, conn);
		}
		return tasks;
	}

	@Override
	public void rmTask(Task arg0) {
		Connection conn = dbUtil.getConnection();
		String sql = "Delete from task WHERE name=?";
		String sql2 = "Delete from file WHERE taskName=?";
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, arg0.getName());
			pst2 = conn.prepareStatement(sql2);
			pst2.setString(1, arg0.getName());
			pst.executeUpdate();
			pst2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(null, pst, conn);
		}		
	}

	@Override
	public Task searchTask(String arg0) {
		Task t = null;
		Connection conn = dbUtil.getConnection();
		String sql = "SELECT * FROM task WHERE name=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, arg0);
			rs = pst.executeQuery();
			if (rs.next()) {  // 存在用户
				t = new Task(rs.getString("name"), TaskType.valueOf(rs.getString("type")), TaskStatus.valueOf(rs.getString("status")));
				String sql2="SELECT * FROM file WHERE taskName=?";
				PreparedStatement pst2 = null;
				ResultSet rs2=null;
				pst2 = conn.prepareStatement(sql2);
				pst2.setString(1, arg0);
				rs2=pst2.executeQuery();
				while (rs2.next()){
					t.addFile(new File(rs2.getString("name"), rs2.getString("path")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pst, conn);
		}
		return t;
	}

	@Override
	public void updateTask(Task arg0) {
		rmTask(arg0);
		addTask(arg0);	
	}

}
