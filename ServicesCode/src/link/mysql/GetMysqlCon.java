package link.mysql;
//����������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL���ݿ������ඨ��
public class GetMysqlCon {
   
   //����һ�����ݿ����ӷ�	
   private Connection MysqlCon = null;	
  
   //���췽��
   public GetMysqlCon(){
	   
	   try{
		    //��������
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			//��Ϣ����
			System.out.println(e.toString());
			System.out.println("��������ʧ��");
		}
	   //���MysqlConΪ�գ���ȡһ�����ӷ���Դ   
	    try{
			 this.MysqlCon = DriverManager.getConnection(MysqlConfig.path, MysqlConfig.username, MysqlConfig.password);
						
		 }catch(SQLException e){
				System.out.print(e.toString());
				System.out.println("MySQL���ӷ���ȡʧ��");
		 }  
   }
   //MySQL������Դ�ͷ�
   public  void closeMysql(){
	   try {
			  this.MysqlCon.close();
		  
		   } catch (SQLException e) {
			
				e.printStackTrace();
				System.out.println("MySQL������Դ�ͷų���");
		   }
   }
   //��ȡ���ݿ����ӷ���get��set����
    public Connection getMysqlCon() {
		return MysqlCon;
	}

	public void setMysqlCon(Connection mysqlCon) {
		MysqlCon = mysqlCon;
	}
	

}
