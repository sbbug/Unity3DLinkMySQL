package link.mysql;

import java.sql.Connection;

/*
 * 
 * MySQL���ݿ����Ӳ�����
 */

public class Test {

	public static void main(String[] args) {
		
		  //����һ������
          Connection con = null;
     
          GetMysqlCon MysqlCon = new GetMysqlCon();
          con = MysqlCon.getMysqlCon();
          if(con==null){
        	  System.out.println("����ʧ��");
          }else{
        	  System.out.println("���ӳɹ� con=====>"+con);
          }
          
          MysqlCon.closeMysql();
	}

}
