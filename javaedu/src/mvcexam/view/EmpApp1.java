package mvcexam.view;

import mvcexam.model.dao.EmpDAO;
import mvcexam.model.vo.EmpVO;

import java.util.List;

public class EmpApp1 {
	public static void main(String[] args) {
		List<EmpVO> r = new EmpDAO().listAll();
		System.out.printf("추출된 데이터 갯수 : %d개 \n",r.size());
		for(EmpVO vo : r)
			System.out.println(vo);	
		System.out.println("===========");
		for(int i=3; i < 8; i++)
			System.out.println(r.get(i));		
		System.out.println("===========");
		for(int i=r.size()-1; i >= 0; i--)
			System.out.println(r.get(i));		
	}
}
