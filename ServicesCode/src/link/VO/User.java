package link.VO;

//�û���
public class User {
    
	//�û���
	private String UserName;
	//�û�����
	private String UserPassword;
	//���췽��
	public User(){
		this.UserName = null;
		this.UserPassword = null;
	}
	//�вι��췽��
	public User(String username,String userpass){
		this.UserName = username;
		this.UserPassword = userpass;
	}
	//set��get����
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
