package kr.co.db_input.dao;

import java.sql.*;
import java.util.ArrayList;
import kr.co.db_input.dto.Dto_input;

public class Dao_input {
	// Connection
	private Connection conn;
	public Dao_input() throws SQLException {
		String aa = "jdbc:mysql://localhost:3307/spring_test?useSSL=false";
		String bb = "root";
		String cc = "1234";
		conn = DriverManager.getConnection(aa,bb,cc);
	}
	
	public void write(Dto_input dto_input) throws SQLException {
		// 쿼리 생성
		String sql = "insert into member(name,age,addr,writeday) ";
		sql = sql + " values(?,?,?,now())";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto_input.getName());
		pstmt.setString(2, dto_input.getAge());
		pstmt.setString(3, dto_input.getAddr());
		
		// 쿼리 실행
		pstmt.executeUpdate();
	}
	
	public ArrayList<Dto_input> list() throws SQLException {
		// select하고 그 내용을 저장(ArrayList)
		// 레코드에 있는 값을 저장할 공간 
		ArrayList<Dto_input> list = new ArrayList<Dto_input>();
		String sql = "select * from member order by id desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) { // 레코드가 있으면 실행
			// list에 레코드를 하나씩 입력(레코드를 Dto_input에 넣은후 Dto_input를 ArrayList에
			list.add(new Dto_input(rs.getString("id"),rs.getString("name"),rs.getString("age"),rs.getString("addr"),rs.getString("writeday")));			
		}
		
		return list;
	}
}
