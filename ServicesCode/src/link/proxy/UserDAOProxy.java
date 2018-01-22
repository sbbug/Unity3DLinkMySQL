package link.proxy;

import link.DAO.UserDAO;
import link.DAOImpl.UserDAOImpl;
import link.VO.User;
import link.mysql.GetMysqlCon;
/*
 * 
 * �û�DAO�Ĵ�����
 * 
 */

public class UserDAOProxy implements UserDAO{

	private GetMysqlCon dbc = null;
	private UserDAO userDAO = null;
	
	//�����๹�췽��
	public  UserDAOProxy(){
		
		this.dbc = new GetMysqlCon();
		
		this.userDAO =new UserDAOImpl(dbc.getMysqlCon());
	    
	}

	//�ж��û��Ƿ����
	@Override
	public boolean FindLogin(User user) {
		
		boolean flag = true;
		try{
			//�жϸ��û��Ƿ����
			flag = this.userDAO.FindLogin(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//�ر����ݿ�
			dbc.closeMysql();
		}
		return flag;
	}
	
	
}
