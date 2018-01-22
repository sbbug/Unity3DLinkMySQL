package link.DAO;
//用户的DAO接口
import link.VO.User;

public interface UserDAO {
    
	//查找登录用户是否存在
	public boolean FindLogin(User user);
	
}
