package mvcexam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mvcexam.model.vo.MeetingVO;
import mvcexam.model.vo.ReplyVO;

public class MeetingDAO {
	public List<MeetingVO> listM() {
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<MeetingVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT id,name, title, TO_CHAR(meetingdate, 'yy/mm/dd hh24:mi') AS meetingdate FROM meeting");
			MeetingVO vo = null;
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setMeetingDate(rs.getString("meetingDate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertM(MeetingVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO meeting VALUES(meeting_seq.NEXTVAL,?,?,?)");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());

			String[] dateStr = vo.getMeetingDate().split("/");
			int[] dateArr = new int[dateStr.length];
			int i = 0;
			for (String a : dateStr) {
				dateArr[i] = Integer.parseInt(a);
				i++;
			}
			LocalDateTime d = LocalDateTime.of(dateArr[0], dateArr[1] - 1, dateArr[2], dateArr[3], dateArr[4]);
			pstmt.setTimestamp(3, Timestamp.valueOf(d));
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("meeting insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<MeetingVO> searchM(String name) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		MeetingVO vo = null;
		ResultSet rs = null;
		List<MeetingVO> list = new ArrayList<>();
		System.out.println(name);
		try {
			pstmt = conn.prepareStatement(
					"SELECT id, name, title, TO_CHAR(meetingdate, 'yy/mm/dd hh:mi') AS md FROM meeting WHERE name = ?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MeetingVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setMeetingDate(rs.getString("md"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt, rs, conn);
		}
		return list;
	}

	public boolean deleteM(int id) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("DELETE FROm meeting WHERE id = " + id);

			if (pstmt.executeUpdate() != 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("delete 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	public List<ReplyVO> listReply(int refid) {
		Connection conn = ConnectDB.connect();
		Statement stmt = null;
		ResultSet rs = null;
		List<ReplyVO> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, content FROM reply where refid = " + refid);
			ReplyVO vo = null;
			while (rs.next()) {
				vo = new ReplyVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setContent(rs.getString("content"));
				vo.setRefid(refid);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}
		return list;
	}

	public boolean insertReply(ReplyVO vo) {
		Connection conn = ConnectDB.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO reply VALUES(reply_seq.NEXTVAL,?,?,?)");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getRefid());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("reply insert 과정에서 오류 발생 " + e);
			return false;
		} finally {
			close(pstmt, null, conn);
		}
	}

	private void close(Statement s, ResultSet r, Connection conn) {
		try {
			if (r != null)
				r.close();
			if (s != null)
				s.close();
			ConnectDB.close(conn);
		} catch (SQLException e) {
			System.err.println("객체 close 과정에서 문제 발생" + e);
		}
	}
}
