package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JdbcUtil;

public class TestJdbc {
	
	public void getAllOperators(){
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			System.out.println("conn:" +conn);
			
			//3.����ִ��sql����Statement����
			Statement stmt = conn.createStatement();
			
			//����һ��Ҫִ�е�sql���
			String sql = "SELECT * from t_operator ";
			
			//4.ִ��sql���,����ǲ�ѯ�Ļ�������һ�������
			ResultSet rs = stmt.executeQuery(sql);
			
			//5.��δӽ�������ȡ����.��ʼ�α��ڵ�һ�е�ǰ�棬next()��ʾ���α��ƶ�����1��
			/*rs.next();
			String id1 = rs.getString(1);//����1��ʾ��1�С�����ȡ���������ǵ�1�е�1�е�
			System.out.println(id1);
			String name1 = rs.getString(2);//����2��ʾ��2�С�����ȡ���������ǵ�1�е�2�е�
			System.out.println(name1);*/
			
			//ѭ��������������������
			while(rs.next()){
				//rs.next()���������£���һ���£��ж���û����һ�У�����У�����true�����û�У�����false;
				//�ڶ����£��������һ�У��ѹ���Ƶ���һ��
				String id1 = rs.getString(1);//����1��ʾ��1�С�����ȡ���������ǵ�1�е�1�е�
				System.out.println(id1);
				String name1 = rs.getString(2);//����2��ʾ��2�С�����ȡ���������ǵ�1�е�2�е�
				System.out.println(name1);
				System.out.println("---------------------------------");
			}
			
			
			
		/*	rs.next();
			String id2 = rs.getString(1);//����1��ʾ��1�С�����ȡ���������ǵ�2�е�1�е�
			System.out.println(id2);
			String name2 = rs.getString(2);//����2��ʾ��2�С�����ȡ���������ǵ�2�е�2�е�
			System.out.println(name2);*/
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//����������ݿ�ʧ�ܣ���ôִ��catch������
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}finally{
			//6.�ͷ���Դ
		}
	}
	

	//�������Ĳ�ѯ
	public void getOperatorById(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			Statement stmt = conn.createStatement();
			//�������������ֵ���͵ģ���ô��Ҫ����''
			String sql = "SELECT * from t_operator where operator_id ='" +id+"'";
			System.out.println(sql );
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String name1 = rs.getString(2);
				System.out.println(name1);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean loginCheck (String name,String pwd){
		boolean r = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			Statement stmt = conn.createStatement();
			//�������������ֵ���͵ģ���ô��Ҫ����''
			String sql = "SELECT * from t_operator WHERE operator_name = '"+name+"' and operator_pwd ='"+pwd+"'";
			System.out.println(sql );
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				r = true;
			}
			
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//rs.close();
		}
		return r;
	}
	
	public int insertOperator(String id,String name,String pwd,String isAdmin){
		int r = 0;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
		/*	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");*/
			
			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			String sql = "insert into t_operator VALUES('"+id+"','"+name+"','" +pwd+  "','"+isAdmin+"')";
			System.out.println(sql);
			
			//��һ���Ͳ�ѯ������executeQuery |  �������޸ġ�ɾ�� executeUpdate
			r = stmt.executeUpdate(sql);
			System.out.println("Ӱ���������" + r);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}
	
	
	//��������
	public int updateOperator(String id,String name,String pwd,String isAdmin){
		int r = 0;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "root");
			
			stmt = conn.createStatement();
			String sql = "UPDATE t_operator set operator_name='"+name+"' ,operator_pwd='"+pwd+"' ,is_admin='"+isAdmin+"'  where operator_id = '"+id+"'";
			System.out.println(sql);
			
			//��һ���Ͳ�ѯ������executeQuery |  �������޸ġ�ɾ�� executeUpdate
			r = stmt.executeUpdate(sql);
			System.out.println("Ӱ���������" + r);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//������û���쳣����ִ��
			if(stmt!=null){
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn !=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		
		TestJdbc t = new TestJdbc();
		//t.getOperatorById("o002");
//		boolean r =  t.loginCheck("john","234reer" );
//		t.insertOperator("o006", "zhang", "666", "Y");
		//t.updateOperator("o002", "����", "0000", "Y");
		
		for(int i=10; i<3500;i++){
			t.insertOperator(i+"", "aaa", "11", "N");
		}
		
	}

}
