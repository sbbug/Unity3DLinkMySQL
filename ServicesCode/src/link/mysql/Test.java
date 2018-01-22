package link.mysql;

import java.sql.Connection;

/*
 * 
 * MySQL数据库连接测试类
 */

public class Test {

	public static void main(String[] args) {
		
		  //定义一个变量
          Connection con = null;
     
          GetMysqlCon MysqlCon = new GetMysqlCon();
          con = MysqlCon.getMysqlCon();
          if(con==null){
        	  System.out.println("连接失败");
          }else{
        	  System.out.println("连接成功 con=====>"+con);
          }
          
          MysqlCon.closeMysql();
	}

}
