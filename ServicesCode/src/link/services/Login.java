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
@WebServlet("/Login") //ע��
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
		
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ����Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����û�����Ϣ�����ڵ���
		System.out.println("username====>"+username);
		System.out.println("password====>"+password);
		
		//����һ�����������
        PrintWriter out = response.getWriter();
        //����һ��DAO����
		UserDAO UserDAO = DAOFactory.GetUserInstance();
		User user = new User(username,password);
		boolean flag = UserDAO.FindLogin(user);
		//����û����ڣ������������1
		if(flag){
			System.out.println("�û�����");
			out.write("1");
	    //����û������ڣ������������0		
		}else{
			System.out.println("�û�������");
			out.write("0");
		}
		
	}

}
