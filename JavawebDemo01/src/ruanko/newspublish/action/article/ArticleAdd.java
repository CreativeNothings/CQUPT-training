package ruanko.newspublish.action.article;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.newspublish.biz.ArticleBiz;
import ruanko.newspublish.entity.Article;



/**
 * 执行添加操作
 * 
 * @author
 *
 */
public class ArticleAdd extends HttpServlet {
	private static final long serialVersionUID = 8814713545848991778L;

	/**
	 * 只允许post方式添加
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决中文乱码问题，这取决于前台jsp页面上设置的编码格式
		request.setCharacterEncoding("utf8");
		
		//采集用户输入的文章信息
		Article article = new Article();
		article.setTitle(request.getParameter("title"));
		article.setAuthor(request.getParameter("author"));
		article.setContent(request.getParameter("content"));
		article.setCreateTime(new Date());

		//创建业务逻辑对象并执行添加新闻操作
		ArticleBiz articleBiz = new ArticleBiz();
		articleBiz.add(article);
		
		//跳转到主页
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}
