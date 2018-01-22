package link.DAO.factory;

import link.DAO.UserDAO;
import link.proxy.UserDAOProxy;

//DAO工厂类定义
public class DAOFactory {

	//使用静态方法
	public static UserDAO GetUserInstance(){
		
		//返回一个DAO代理类对象
		return new UserDAOProxy();
	}
}
