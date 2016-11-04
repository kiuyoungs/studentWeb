package com.studentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.student.entity.Attendance;
import com.student.entity.Student;
import Util.JdbcUtil;



public class studentDao {
	
	public int updateStudent(Attendance stu){
		int r= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			
			conn = JdbcUtil.getConn();
			String sql = "update attendance set c_id=?,k_id=?,k_date=?,k_rec where stu_id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stu.getCourseId());
			pstmt.setString(2, stu.getAttenId());
			pstmt.setString(3, stu.getAttenDate());
			pstmt.setString(4, stu.getAttenRecord());
			pstmt.setString(5, stu.getStudentId());
			
			r = pstmt.executeUpdate();
			System.out.println("��Ӱ���������"+r);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, pstmt, conn);
		}
		return r;
		
	}
	
	public Attendance getStudentById(String stuId){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Attendance o = new Attendance();
		try {
			
			conn = JdbcUtil.getConn();
			
			
			String sql = "select * from attendance where stu_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				o.setStudentId(rs.getString(1));
				o.setCourseId(rs.getString(2));
				o.setAttenId(rs.getString(3));
				o.setAttenDate(rs.getString(4));
				o.setAttenRecord(rs.getString(5));
				
			}
			rs.close();
//			for(int i=0;i<ids.length;i++){
//				pstmt.setString(1, ids[i]);
//				pstmt.addBatch();
//			}
//			//ִ������ѭ��֮��
//			int[] r1 = pstmt.executeBatch();
//			r= r1[0];
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(rs, null, conn);
		}
		return o;
	}
	
	public int deleteStudent(String stuId){
		int r= 0;
		Connection conn = null;
		PreparedStatement pstmt;
		try {
			
			conn = JdbcUtil.getConn();
			
			
			String sql = "delete from attendance where stu_id = ?";
//			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuId);
			
			r = pstmt.executeUpdate();
			System.out.println("��Ӱ���������"+r);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, null, conn);
		}
		return r;
	}
	
	public ArrayList<Attendance> getStudents(String sql){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Attendance> stuList = new ArrayList<Attendance>();
		try {
		
			conn = JdbcUtil.getConn();
			 stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				//rs.next()���������� ����һ�����ж���û����һ�У�����з���true��û�У�����false��
				//�ڶ����£��������һ����ѹ���Ƶ���һ��
				Attendance o = new Attendance();
				o.setStudentId(rs.getString(1));
				o.setCourseId(rs.getString(2));
				o.setAttenId(rs.getString(3));
				o.setAttenDate(rs.getString(4));
				o.setAttenRecord(rs.getString(5));
				
				stuList.add(o);
			}
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ��"+e.getMessage());
		}finally{
			JdbcUtil.free(rs, stmt, conn);
		}
		return stuList;
	}
	
	public Attendance countStudnet(Attendance stu){
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		Attendance o = new Attendance();
		try {
			
			conn = JdbcUtil.getConn();
			String sql = "select count(*) AS stu_id,c_id,k_id,k_date,k_rec from attendance where k_rec='���'";
			pstmt = conn.prepareStatement(sql);
			
			
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				o.setStudentId(rs.getString(1));
				o.setCourseId(rs.getString(2));
				o.setAttenId(rs.getString(3));
				o.setAttenDate(rs.getString(4));
				o.setAttenRecord(rs.getString(5));
				
			}
			rs.close();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(null, pstmt, conn);
		}
		return o;
		
	}
	
	public int addStudent1(Attendance stu) {
		int r = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			

			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			String sql = "insert into attendance VALUES("+stu.getStudentId() +","+stu.getCourseId()+","+stu.getAttenId()+",'" + stu.getAttenDate() + "','" 
				     + stu.getAttenRecord()	+ "')";
			System.out.println(sql);
			// ��һ���Ͳ�ѯ������executeQuery | �������޸ġ�ɾ�� executeUpdate
			r = stmt.executeUpdate(sql);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}

	public boolean loginCheck1(String name,String pwd){
		boolean f = false;
		Connection conn = null;
//		Statement stmt = null;
		//��ע��
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		try {
			//ע������
//			Class.forName("com.mysql.jdbc.Driver");
			//��������
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "");
			conn = JdbcUtil.getConn();	
			//����ִ��sql����statement����
//			stmt = conn.createStatement();
			
			//����һ��Ҫִ�е�sql���
			String sql = "SELECT * FROM account WHERE account = ? and password = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			System.out.println(sql);
			//ִ��sql��䣬����ǲ�ѯ�Ļ�������һ�������
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				f = true;
			}
			
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(rs, null, conn);
		}
		return f;
	}
	
	public boolean loginCheck2(String name,String pwd){
		boolean f = false;
		Connection conn = null;
//		Statement stmt = null;
		//��ע��
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		try {
			//ע������
//			Class.forName("com.mysql.jdbc.Driver");
			//��������
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cma", "root", "");
			conn = JdbcUtil.getConn();	
			//����ִ��sql����statement����
//			stmt = conn.createStatement();
			
			//����һ��Ҫִ�е�sql���
			String sql = "SELECT * FROM manager WHERE g_number = ? and g_password = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			System.out.println(sql);
			//ִ��sql��䣬����ǲ�ѯ�Ļ�������һ�������
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				f = true;
			}
			
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(rs, null, conn);
		}
		return f;
	}
	
	public int addStudent(Student stu) {
		int r = 0;
		Connection conn = null;
		Statement stmt = null;

		try {
			

			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			String sql = "insert into student VALUES('" + stu.getStudentName() + "','" 
			     + stu.getStudentSex()	+ "','" + stu.getStudentBirthday() + "','" + stu.getStudentContact() + "',"
			     +stu.getStudentId() + "," + stu.getStudentClass() + ")";
			String sql2 = "insert into account VALUES(" + stu.getStudentId() + "," 
				     + stu.getStudentId()	+ ",'" + stu.getStudentPwd()+"')";
			System.out.println(sql);
			System.out.println(sql2);
			// ��һ���Ͳ�ѯ������executeQuery | �������޸ġ�ɾ�� executeUpdate
			r = stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.free(null, stmt, conn);
		}
		return r;
	}
	
@SuppressWarnings("unchecked")
public ArrayList getAllStudents(){
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList stuList = new ArrayList();
		try {
		
		
			conn = JdbcUtil.getConn();
			 stmt = conn.createStatement();
			
			//����һ��Ҫִ�е�sql���
			String sql = "SELECT * from attendance";
	
			//ִ��sql��䣬����ǲ�ѯ�Ļ�������һ�������
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				//rs.next()���������� ����һ�����ж���û����һ�У�����з���true��û�У�����false��
				//�ڶ����£��������һ����ѹ���Ƶ���һ��
				Attendance o = new Attendance();
				o.setStudentId(rs.getString(1));
				o.setCourseId(rs.getString(2));
				o.setAttenId(rs.getString(3));
				o.setAttenDate(rs.getString(4));
				o.setAttenRecord(rs.getString(5));
				stuList.add(o);
			}
		 
			
			//ѭ������������������
			
			
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ��"+e.getMessage());
		}finally{
			JdbcUtil.free(rs, stmt, conn);
		}
		return stuList;
	}
	
}
