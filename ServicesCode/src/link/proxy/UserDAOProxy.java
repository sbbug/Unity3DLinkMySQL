package link.proxy;

import link.DAO.UserDAO;
import link.DAOImpl.UserDAOImpl;
import link.VO.User;
import link.mysql.GetMysqlCon;
/*
 * 
 * 用户DAO的代理类
 * 
 */

public class UserDAOProxy implements UserDAO{

	private GetMysqlCon dbc = null;
	private UserDAO userDAO = null;
	
	//代理类构造方法
	public  UserDAOProxy(){
		
		this.dbc = new GetMysqlCon();
		
		this.userDAO =new UserDAOImpl(dbc.getMysqlCon());
	    
	}

	//判断用户是否存在
	@Override
	public boolean FindLogin(User user) {
		
		boolean flag = true;
		try{
			//判断该用户是否存在
			flag = this.userDAO.FindLogin(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭数据库
			dbc.closeMysql();
		}
		return flag;
	}
	
	
}
