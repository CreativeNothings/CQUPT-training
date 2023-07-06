package ruanko.newspublish.action.article;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.newspublish.biz.ArticleBiz;
import ruanko.newspublish.entity.Article;


/**
 * 显示文章列表
 * 
 * @author
 *
 */
public class ArticleShowList extends HttpServlet {
	private static final long serialVersionUID = 8850679539463822306L;

	/**
	 * 只允许了get方式访问
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//创建业务逻辑对象，取出所有文章
		ArticleBiz articleBiz = new ArticleBiz();
		List<Article> articles = articleBiz.getOneYearData();

		//将取出的文章添加到request里，以便在跳转到jsp之后可以取出这些文章
		request.setAttribute("articles", articles);

		//跳转到显示新闻的列表页
		request.getRequestDispatcher("shownews.jsp").forward(request, response);
	}
}
