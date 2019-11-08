package kr.co.db_input.dao;

import java.sql.*;
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
	
	public void list() {
		
	}
}
