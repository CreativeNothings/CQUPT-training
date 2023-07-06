package ruanko.newspublish.biz;

import java.util.List;

import ruanko.newspublish.dao.ArticleDao;
import ruanko.newspublish.entity.Article;



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
public class ArticleBiz {

	/**
	 * 文章dao
	 */
	private ArticleDao articleDao;

	public ArticleBiz() {
		this.articleDao = new ArticleDao();
	}
	/**
	 * 添加
	 * 
	 * @param article 
	 * 			文章
	 */
	public void add(Article article) {
		articleDao.add(article);
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * 			文章編号
	 */
	public void delete(int id) {
		articleDao.delete(id);
	}
	
	/**
	 * 更新
	 * 
	 * @param article
	 * 			文章
	 * 
	 */
	public void update(Article article) {
		articleDao.update(article);
	}
	
	/**
	 * 得到一个文章
	 * 
	 * @param id 
	 * 			文章编号
	 * 
	 * @return 文章
	 */
	public Article get(int id) {
		return articleDao.get(id);
	}
	
	/**
	 * 得到所有文章
	 * 
	 * @return 所有文章
	 */
	public List<Article> getAll(){
		return articleDao.getAll();
	}

	/**
	 * 获取一年内的文章
	 *
	 * @return 所有
	 */
	public List<Article> getOneYearData(){
		return articleDao.getByCreateTime();
	}
	
	
}
