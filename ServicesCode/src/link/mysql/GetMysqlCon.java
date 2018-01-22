package link.mysql;
//导入相关类包
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL数据库连接类定义
public class GetMysqlCon {
   
   //定义一个数据库连接符	
   private Connection MysqlCon = null;	
  
   //构造方法
   public GetMysqlCon(){
	   
	   try{
		    //加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			//信息报错
			System.out.println(e.toString());
			System.out.println("驱动加载失败");
		}
	   //如果MysqlCon为空，获取一个连接符资源   
	    try{
			 this.MysqlCon = DriverManager.getConnection(MysqlConfig.path, MysqlConfig.username, MysqlConfig.password);
						
		 }catch(SQLException e){
				System.out.print(e.toString());
				System.out.println("MySQL连接符获取失败");
		 }  
   }
   //MySQL连接资源释放
   public  void closeMysql(){
	   try {
			  this.MysqlCon.close();
		  
		   } catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("MySQL连接资源释放出错");
		   }
   }
   //获取数据库连接符的get与set方法
    public Connection getMysqlCon() {
		return MysqlCon;
	}

	public void setMysqlCon(Connection mysqlCon) {
		MysqlCon = mysqlCon;
	}
	

}
