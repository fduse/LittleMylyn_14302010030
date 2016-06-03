package com.littlemylyn.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.littlemylyn.util.DBUtil;

public class DBUtilTest {
	DBUtil dBUtil;
	
	@Before
	public void setUp() {
		dBUtil = new DBUtil();
	}

	@Test
	public void testDBUtil() {
		System.out.println(dBUtil.toString());
	}

	@Test
	public void testGetConnection() {
		Connection conn = dBUtil.getConnection();
		System.out.println(conn.toString());
	}

}
