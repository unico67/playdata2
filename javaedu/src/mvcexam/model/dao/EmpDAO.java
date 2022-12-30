package mvcexam.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvcexam.model.vo.EmpVO;

public class EmpDAO {
	public int getAllDataNum() {		
		Connection conn = ConnectDB.connect();
		int num = 0;
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select count(*) from emp");) {
			rs.next();
			num = rs.getInt(1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return num;
	}
	
	public List<EmpVO> listAll() {
		Connection conn = ConnectDB.connect();
		List<EmpVO> list = new ArrayList<>();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select empno, ename, job, to_char(hiredate, 'yyyy\"년\" mm\"월\" dd\"일\"') hd, sal  from emp");) {
			EmpVO vo;
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setHiredate(rs.getString("hd"));
				vo.setSal(rs.getInt("sal"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	
	public List<EmpVO> listPart(int start, int end) {
		Connection conn = ConnectDB.connect();
		List<EmpVO> list =  new ArrayList<>();
		String sql = "select * from (select imsi.*, rownum r from (select * from emp order by sal desc) imsi) where r >= ? and r <= ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			EmpVO vo;
			while(rs.next()) {
				vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setHiredate(rs.getString("hiredate"));
				vo.setSal(rs.getInt("sal"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			ConnectDB.close(conn);
		}
		return list;
	}
}
