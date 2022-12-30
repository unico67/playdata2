package mvcexam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvcexam.model.vo.VisitorVO;

public class VisitorDAO {
	public List<VisitorVO> listAll() {
		Connection conn = ConnectDB.connect();
		List<VisitorVO> list = new ArrayList<>();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo  from visitor");) {
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMemo(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	
	public VisitorVO one(int id) {
		Connection conn = ConnectDB.connect();
		VisitorVO vo = null;
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo  from visitor where id = "+id);) {			
			if(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMemo(rs.getString(4));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return vo;
	}
	public List<VisitorVO> search(String keyword) {
		Connection conn = ConnectDB.connect();
		List<VisitorVO> list = new ArrayList<>();
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery
				("select id, name, to_char(writedate, 'yyyy\"년\" mm\"월\" dd\"일\"'), memo "
						+"from visitor where memo like '%"+keyword+"%'");) {
			VisitorVO vo;
			while(rs.next()) {
				vo = new VisitorVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setWriteDate(rs.getString(3));
				vo.setMemo(rs.getString(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return list;
	}
	public boolean insert(VisitorVO vo) {
		Connection conn = ConnectDB.connect();
		boolean result = true;		
		try (PreparedStatement pstmt = conn.prepareStatement(
						"insert into visitor values(visitor_seq.nextval, ?, sysdate, ?)");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2,  vo.getMemo());			
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return result;
	}
	public boolean delete(int id) {
		Connection conn = ConnectDB.connect();
		boolean result = true;		
		try (PreparedStatement pstmt = conn.prepareStatement(
						"delete from visitor where id = ?");) {
			pstmt.setInt(1, id); 
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result =false;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return result;
	}
	public boolean update(VisitorVO vo) {	
		Connection conn = ConnectDB.connect();
		boolean result = true;
		try (PreparedStatement pstmt = conn.prepareStatement(
						"update visitor set name = ?, memo = ? where id = ?");) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2,  vo.getMemo());
			pstmt.setInt(3,  vo.getId());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn);
		}
		return result;
	}
}


