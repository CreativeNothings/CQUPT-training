package ruanko.newspublish.dao;

import ruanko.newspublish.entity.User;
import ruanko.newspublish.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 文章数据库操作
 * 
 * @author
 *
 */
public class UserDao extends BaseDao{

	/**
	 * 用户名获取用户信息
	 * @param userName
	 * 			文章编号
	 * @return 文章
	 */
	public User queryByName(String userName) {
		String sql = "select * from user where user_name = '" + userName + "'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
				user.setNickName(resultSet.getString("nick_name"));
				closeAll(connection, statement, resultSet);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加
	 * @param user
	 * 			文章
	 */
	public void add(User user) {
		String sql = "INSERT INTO user(user_name, pass_word) VALUES('" +
				user.getUserName() +
				"','" +
				user.getPassword() +
				"')";
		executeUpdate(sql);
	}
	
	

	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id) {
		String sql = "DELETE FROM user WHERE id=" + id;
		executeUpdate(sql);
	}
	
//	/**
//	 * 更新
//	 * @param user
//	 * 			文章
//	 *
//	 */
//	public void update(User user) {
//		String sql = "UPDATE user SET title='" +
//				user.getTitle() +
//				"', author='" +
//				user.getAuthor() +
//				"', content='" +
//				user.getContent() +
//				"' WHERE id=" + user.getId();
//		executeUpdate(sql);
//	}
	
	/**
	 * 得到一个文章
	 * @param id
	 * 			文章编号
	 * @return 文章
	 */
	public User get(int id) {

		String sql = "SELECT * FROM user WHERE id=" + id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("user_name"));
				user.setNickName(resultSet.getString("nick_name"));
				user.setSex(resultSet.getInt("sex"));
				user.setRemark(resultSet.getString("remark"));
				user.setCreateTime(resultSet.getDate("create_time"));

				closeAll(connection, statement, resultSet);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}