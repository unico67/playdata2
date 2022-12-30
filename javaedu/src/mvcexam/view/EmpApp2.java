package mvcexam.view;

import mvcexam.model.dao.EmpDAO;
import mvcexam.model.vo.EmpVO;

import java.util.List;

public class EmpApp2 {
	public static void main(String[] args)  {
		EmpDAO dao = new EmpDAO();
		int end = dao.getAllDataNum();
		System.out.printf("emp 테이블의 데이터 갯수 : %d개 \n",end);
		List<EmpVO> r = dao.listPart(1, end);
		for(EmpVO vo : r)
			System.out.println(vo);
		System.out.println("===========");
		r = dao.listPart(3, 6);
		for(EmpVO vo : r)
			System.out.println(vo);
		System.out.println("===========");
		r = dao.listPart(10, end);
		for(EmpVO vo : r)
			System.out.println(vo);
	}
}
