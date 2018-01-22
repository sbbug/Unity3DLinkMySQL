package link.DAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import link.DAO.UserDAO;
import link.VO.User;

public class UserDAOImpl implements UserDAO{
   
	//�����û�˽�б���
	private User user;
	//�������ݿ����ӷ�
	private Connection conn = null;
	//�������ݿ����Ӳ�ѯ��
	private PreparedStatement ps = null;
	
	//�޲ι��췽��
	public UserDAOImpl(){
		this.user = null;
	}
	//�вι��췽��
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}
	
	//ʵ�ֲ����û��Ƿ���ڵķ���
	@Override
	public boolean FindLogin(User user){
		
		System.out.println("username===>"+user.getUserName());
		System.out.println("password===>"+user.getUserPassword());
		
		//��һ����־���ж��û��Ƿ����
		boolean flag = false;
		
		try {
			
			//����һ��sql���  
			String sql = "select user_name from fengku.UserInfo where user_name='"+user.getUserName()+"' and user_password='"+user.getUserPassword()+"'";
			System.out.println("sql==="+sql);
			
			//׼��sql���
			 this.ps = this.conn.prepareStatement(sql);
			//�������ƴ�����ݣ��ֱ����û���������
			 //this.ps.setString(1,user.getUserName());
			 //this.ps.setString(2,user.getUserPassword());
			 
			//System.out.println("sql==="+sql);
			
			//ִ��sql���
			ResultSet rs = this.ps.executeQuery(sql);
			if(rs.next()){
				//��¼��������Ϊ��
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//ps��Դ�������Ҫ���̹رգ����ݿ����ӷ�����Ҫ���̹ر�
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
