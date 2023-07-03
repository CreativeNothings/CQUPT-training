package com.DAO.Impl;

import com.DAO.UserDao;
import com.Entity.User;
import com.Util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class UserDaoImpl implements UserDao {
	@Override
	public User selbyUsername(User user) {
		User returnUser = null;
		Connection con = null;
		// 定义执行对象
		PreparedStatement ps = null;
		// 定义结果集
		ResultSet rs = null;
		try {
			con = DBHelper.getCon();
			ps = con.prepareStatement("select * from user where username='" + user.getUsername() + "'");
			rs = ps.executeQuery();
			if (rs.next()) {
				returnUser = new User();
				returnUser.setId(user.getId());
				returnUser.setUsername(rs.getString(2));
				returnUser.setPassword(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.getClose(con, ps, rs);
		}
		return returnUser;
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		int result =0;
		Connection con=null;
		PreparedStatement ps =null;
		try {
			con=DBHelper.getCon();
			String sql="insert into user(username,password,age,gender,email)"
					+"values('"+user.getUsername()+"','"
					+user.getPassword()+"',"
					+user.getAge()+",'"
					+user.getGender()+"','"
					+user.getEmail()+"')";
			ps  =con.prepareStatement(sql);
			result =ps.executeUpdate();
					}catch(Exception e){
						e.printStackTrace();
					}finally {
						DBHelper.getClose(con, ps, null);
					}
		
		return result;
	}
	
	@Test
	public void testInsertUser() {
		User user =new User();
		user.setUsername("mary");
		user.setPassword("123");
		user.setAge(22);
		user.setGender("男");
		user.setEmail("111@qq.com");
		int i = this.insertUser(user);
		System.out.println(i);
	}
}
