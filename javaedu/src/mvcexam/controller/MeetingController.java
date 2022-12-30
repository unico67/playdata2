package mvcexam.controller;

import java.util.List;

import mvcexam.model.dao.MeetingDAO;
import mvcexam.model.vo.MeetingVO;
import mvcexam.model.vo.ReplyVO;

public class MeetingController {
	private MeetingDAO dao;
	public MeetingController() {
		dao = new MeetingDAO();	
	}
	
	public void meetingCreate(String name, String title, String stringmdate) {
		MeetingVO vo = new MeetingVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setMeetingDate(stringmdate);
		
		boolean result = dao.insertM(vo);
		if (result)
			System.out.println("meeting 저장 성공");
		else 
			System.out.println("meeting 저장 실패");
		
	}
	public void replyCreate(int refid, String name, String content) {
		ReplyVO vo = new ReplyVO();
		vo.setName(name);
		vo.setContent(content);
		vo.setRefid(refid);
		
		boolean result = dao.insertReply(vo);
		if (result)
			System.out.println("reply 저장 성공");
		else 
			System.out.println("reply 저장 실패");
	}
	public void meetingRead() {
		List<MeetingVO> list = dao.listM(); 
		for(MeetingVO vo : list) {
			System.out.print(vo.getId()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getMeetingDate()+"\t");
			System.out.println(vo.getTitle());
		}		
	}
	public void meetingRWithName(String name) {
		List<MeetingVO> list = dao.searchM(name); 
		for(MeetingVO vo : list) {
			System.out.print(vo.getId()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getMeetingDate()+"\t");
			System.out.println(vo.getTitle());
		}	
	}

	public void replyRead(int refid) {
		List<ReplyVO> list = dao.listReply(refid); 
		for(ReplyVO vo : list) {
			System.out.print("\t");
			System.out.print(vo.getId()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getContent()+"\t");
			System.out.println(vo.getRefid());
		}
	}

	public void meetingDelete(int id) {
		boolean result = dao.deleteM(id);
		if (result)
			System.out.println("삭제 성공");
		else 
			System.out.println("삭제 실패");
	}
}
