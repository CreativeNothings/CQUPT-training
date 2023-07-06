package ruanko.newspublish.biz;

import ruanko.newspublish.dao.UserDao;
import ruanko.newspublish.entity.User;

import java.util.List;


/**
 * 文章业务逻辑<br>
 * 一般来说，我只将具体的操作交由具体的功能类来完成，
 * 比如，需要操作数据库了，就让dao类去做<br>
 * 这时候好多人认为业务逻辑类的存在是没有必要的，
 * 上层的servlet完全可以直接调用dao类去进行数据库操作<br>
 * 
 * 业务逻辑层有利于系统的维护与扩展
 * 
 * @author
 *
 */
public class UserBiz {

	/**
	 * 文章dao
	 */
	private UserDao userDao;

	public UserBiz() {
		this.userDao = new UserDao();
	}
	/**
	 * 添加
	 * 
	 * @param userName
	 * 			文章
	 */
	public User queryByName(String userName) {
		return userDao.queryByName(userName);
	}
	/**
	 * 添加
	 *
	 * @param user
	 * 			文章
	 */
	public void add(User user) {
		userDao.add(user);
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * 			文章編号
	 */
	public void delete(int id) {
		userDao.delete(id);
	}
	
//	/**
//	 * 更新
//	 *
//	 * @param user
//	 * 			文章
//	 *
//	 */
//	public void update(User user) {
//		userDao.update(user);
//	}
	
	/**
	 * 得到一个文章
	 * 
	 * @param id 
	 * 			文章编号
	 * 
	 * @return 文章
	 */
	public User get(int id) {
		return userDao.get(id);
	}

}
