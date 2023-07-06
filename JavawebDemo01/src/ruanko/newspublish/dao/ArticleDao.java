package ruanko.newspublish.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ruanko.newspublish.entity.Article;



/**
 * 文章数据库操作
 * 
 * @author
 *
 */
public class ArticleDao extends BaseDao{

	/**
	 * 添加
	 * @param article 
	 * 			文章
	 */
	public void add(Article article) {
		String sql = "INSERT INTO article(title, author, content) VALUES('" +
				article.getTitle() +
				"','" +
				article.getAuthor() +
				"','" +
				article.getContent() +
				"')";
		executeUpdate(sql);
	}
	
	

	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id) {
		String sql = "DELETE FROM article WHERE id=" + id;
		executeUpdate(sql);
	}
	
	/**
	 * 更新
	 * @param article
	 * 			文章
	 * 
	 */
	public void update(Article article) {
		String sql = "UPDATE article SET title='" +
				article.getTitle() +
				"', author='" +
				article.getAuthor() +
				"', content='" +
				article.getContent() +
				"' WHERE id=" + article.getId();
		executeUpdate(sql);
	}
	
	/**
	 * 得到一个文章
	 * @param id 
	 * 			文章编号
	 * @return 文章
	 */
	public Article get(int id) {
		
		String sql = "SELECT * FROM article WHERE id=" + id;
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Article article = new Article();
				article.setId(resultSet.getInt("id"));
				article.setTitle(resultSet.getString("title"));
				article.setAuthor(resultSet.getString("author"));
				article.setContent(resultSet.getString("content"));

				closeAll(connection, statement, resultSet);
				return article;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 得到所有文章
	 * @return 所有文章
	 */
	public List<Article> getAll(){
		List<Article> articles;
		String sql = "SELECT * FROM article";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			articles = new ArrayList<Article>();
			while (resultSet.next()) {
				Article article = new Article();
				article.setId(resultSet.getInt("id"));
				article.setTitle(resultSet.getString("title"));
				article.setAuthor(resultSet.getString("author"));
				article.setContent(resultSet.getString("content"));
				articles.add(article);
			}
			closeAll(connection, statement, resultSet);
			return articles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到一个文章
	 * @param
	 *
	 * @return 文章
	 */
	public List<Article> getByCreateTime() {
		List<Article> articles;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR,-1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT * FROM article WHERE create_time >= '" + sdf.format(calendar.getTime()) + "'";
		Connection connection = getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			articles = new ArrayList<Article>();
			while (resultSet.next()) {
				Article article = new Article();
				article.setId(resultSet.getInt("id"));
				article.setTitle(resultSet.getString("title"));
				article.setAuthor(resultSet.getString("author"));
				article.setContent(resultSet.getString("content"));
				article.setCreateTime(resultSet.getDate("create_time"));
				articles.add(article);
			}
			closeAll(connection, statement, resultSet);
			return articles;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}