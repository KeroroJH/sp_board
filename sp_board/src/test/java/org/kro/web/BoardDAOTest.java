package org.kro.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;
import org.kro.cmmn.PageMaker;
import org.kro.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class BoardDAOTest {
	
	@Autowired
	private BoardDAO dao;

	@Test
	public void listAllTest() {
		List<BoardVO> lis = dao.listAll();
		for( BoardVO li : lis){
			System.out.println(li.toString());
		}
		System.out.println(dao.getTime());
	}

	@Test
	public void insertTest(){
		BoardVO vo = new BoardVO(1,"제목입니다","작성자 1", "내용 1234556입니다 ");
		System.out.println(dao.insert(vo));
	}
	
	@Test
	public void modifyTest(){
		BoardVO vo = new BoardVO(1,"제목입니다","작성자 1", "내용 1234556입니다 ");
			vo.setBno(10);
		System.out.println(dao.modify(vo));
	}
	
	@Test
	public void teadTest(){
		Map map = new HashMap<String, String>();
			map.put("bno", "13");
		BoardVO vo = dao.read(map);
		System.out.println(vo.toString());
	}
	
	@Test
	public void deleteTest(){
		Map map = new HashMap<String, String>();
			map.put("bno", "4");		
		dao.remove(map);
	}
	
	@Test
	public void viewCountUp(){
		Map map = new HashMap<String, String>();
			map.put("bno", "10");
			dao.viewCount(map);
	}
	
	@Test
	public void listPage(){
		PageInfo info = new PageInfo();
		info.setPage(4);
		dao.listPage(info);
	}
	
	@Test
	public void getTotalRowCount(){
		PageInfo pi = new PageInfo();
		pi.setSearchType("t");
		pi.setKeyword("제목입니다");
		System.out.println("/count / : "+dao.getTotalRowCount(pi));
		
	}
}





