package ruanko.newspublish.action.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.newspublish.biz.ArticleBiz;
import ruanko.newspublish.entity.Article;



/**
 * 显示一篇新闻
 * 
 * @author
 *
 */
public class ArticleShow extends HttpServlet {
	private static final long serialVersionUID = 5594987448931704969L;

	/**
	 * 为什么只处理get方式<br>
	 * 当用户浏览一个具体的新闻时，如果想分享给朋友，就需要将网址复制下来，发送给朋友，这时，网址中应当是包含新闻信息的，例如：新闻的id
	 * 
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到网址中包含的新闻id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//创建业务逻辑对象获取该新闻
		ArticleBiz articleBiz = new ArticleBiz();
		Article article = articleBiz.get(id);
		
		//将该新闻添加到request里，供jsp页面显示
		request.setAttribute("article", article);
		
		//跳转到显示一篇新闻的页面
		request.getRequestDispatcher("showdetail.jsp").forward(request, response);
	}


}
