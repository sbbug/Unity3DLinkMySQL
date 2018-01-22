package link.DAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import link.DAO.UserDAO;
import link.VO.User;

public class UserDAOImpl implements UserDAO{
   
	//定义用户私有变量
	private User user;
	//定义数据库连接符
	private Connection conn = null;
	//定义数据库链接查询符
	private PreparedStatement ps = null;
	
	//无参构造方法
	public UserDAOImpl(){
		this.user = null;
	}
	//有参构造方法
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	//实现查找用户是否存在的方法
	@Override
	public boolean FindLogin(User user){
		
		System.out.println("username===>"+user.getUserName());
		System.out.println("password===>"+user.getUserPassword());
		
		//设一个标志，判断用户是否存在
		boolean flag = false;
		
		try {
			
			//定义一个sql语句  
			String sql = "select user_name from fengku.UserInfo where user_name='"+user.getUserName()+"' and user_password='"+user.getUserPassword()+"'";
			System.out.println("sql==="+sql);
			
			//准备sql语句
			 this.ps = this.conn.prepareStatement(sql);
			//向语句中拼接数据，分别是用户名和密码
			 //this.ps.setString(1,user.getUserName());
			 //this.ps.setString(2,user.getUserPassword());
			 
			//System.out.println("sql==="+sql);
			
			//执行sql语句
			ResultSet rs = this.ps.executeQuery(sql);
			if(rs.next()){
				//记录存在设置为真
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//ps资源符用完就要立刻关闭，数据库连接符不需要立刻关闭
			if(this.ps!=null){
				try{
					this.ps.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	  }
}
