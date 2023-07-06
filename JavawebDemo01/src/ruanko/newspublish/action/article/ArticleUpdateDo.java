package ruanko.newspublish.action.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.newspublish.biz.ArticleBiz;
import ruanko.newspublish.entity.Article;


/**
 * 执行真正的文章更新操作,指用户完成了编辑，点击保存后所执行的操作
 * 
 * @author
 * @see ArticleUpdate
 */
public class ArticleUpdateDo extends HttpServlet {
	private static final long serialVersionUID = 506610760643155054L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//涉及用户输入信息的地方都要处理中文乱码问题
		//解决中文乱码问题，这取决于前台jsp页面上设置的编码格式
		request.setCharacterEncoding("utf8");
		
		//采集用户输入的新闻
		Article article = new Article();
		article.setId(Integer.parseInt(request.getParameter("id")));
		article.setTitle(request.getParameter("title"));
		article.setAuthor(request.getParameter("author"));
		article.setContent(request.getParameter("content"));
		
		//创建业务逻辑对象，执行更新(修改)操作
		ArticleBiz articleBiz = new ArticleBiz();
		articleBiz.update(article);
		
		//跳转到主页
		//不过好像这里跳转到新闻列表页会更合适一些
		//也许这个问题会在下一版的《最小新闻发布系统》在解决吧
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
