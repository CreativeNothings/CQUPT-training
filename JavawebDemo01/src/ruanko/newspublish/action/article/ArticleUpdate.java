package ruanko.newspublish.action.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ruanko.newspublish.biz.ArticleBiz;
import ruanko.newspublish.entity.Article;


/**
 * 要修改新闻，首先要将新闻显示给用户，这样才能修改，本类用于将新闻显示给用户
 * 
 * @author
 *
 */
public class ArticleUpdate extends HttpServlet {
	private static final long serialVersionUID = -7258058424002586258L;

	/**
	 * 这里好像可以是post也可以是get没有太大的区别，不过为了简单起见，这里只处理了get方法
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到要修改新闻的id
		int id = Integer.parseInt(request.getParameter("id"));
		
		//创建业务逻辑对象，并取得该新闻
		ArticleBiz articleBiz = new ArticleBiz();
		Article article = articleBiz.get(id);
		
		//将该新闻添加到request里，供jsp显示出来，具体是显示在编辑框里还是什么地方我就管不着了，反正我给它了
		request.setAttribute("article", article);
		
		//跳转到修改页面
		request.getRequestDispatcher("updatedetail.jsp").forward(request, response);
	}
}
