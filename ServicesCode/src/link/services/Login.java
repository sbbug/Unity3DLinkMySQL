package link.services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import link.DAO.UserDAO;
import link.DAO.factory.DAOFactory;
import link.VO.User;
import link.proxy.UserDAOProxy;

/*
 * Servlet implementation class Login
 */
@WebServlet("/Login") //注释
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//获取表单信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//输出用户表单信息，用于调试
		System.out.println("username====>"+username);
		System.out.println("password====>"+password);
		
		//定义一个输出流对象
        PrintWriter out = response.getWriter();
        //创建一个DAO对象
		UserDAO UserDAO = DAOFactory.GetUserInstance();
		User user = new User(username,password);
		boolean flag = UserDAO.FindLogin(user);
		//如果用户存在，向服务器返回1
		if(flag){
			System.out.println("用户存在");
			out.write("1");
	    //如果用户不存在，向服务器返回0		
		}else{
			System.out.println("用户不存在");
			out.write("0");
		}
		
	}

}
