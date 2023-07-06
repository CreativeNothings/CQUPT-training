package ruanko.newspublish.register;

import ruanko.newspublish.biz.UserBiz;
import ruanko.newspublish.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 执行添加操作
 * 
 * @author
 *
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 8814713545848991778L;

	/**
	 * 只允许post方式添加
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解决中文乱码问题，这取决于前台jsp页面上设置的编码格式
		request.setCharacterEncoding("utf8");

		//创建业务逻辑对象，用户名查询用户
		UserBiz userBiz = new UserBiz();
		User user = userBiz.queryByName(request.getParameter("userName"));
		if (user == null) {
			response.addHeader("msg","用户名不存在！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String p1= request.getParameter("password");
			String p2= user.getPassword();
			if (p1.equals(p2)){
				//跳转到主页
				request.setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.addHeader("msg","用户名密码错误！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
