package link.VO;

//用户类
public class User {
    
	//用户名
	private String UserName;
	//用户密码
	private String UserPassword;
	//构造方法
	public User(){
		this.UserName = null;
		this.UserPassword = null;
	}
	//有参构造方法
	public User(String username,String userpass){
		this.UserName = username;
		this.UserPassword = userpass;
	}
	//set和get方法
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
}
