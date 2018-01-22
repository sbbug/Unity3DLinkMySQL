package link.DAO.factory;

import link.DAO.UserDAO;
import link.proxy.UserDAOProxy;

//DAO�����ඨ��
public class DAOFactory {

	//ʹ�þ�̬����
	public static UserDAO GetUserInstance(){
		
		//����һ��DAO���������
		return new UserDAOProxy();
	}
}
