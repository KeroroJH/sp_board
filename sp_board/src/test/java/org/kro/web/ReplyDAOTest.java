package org.kro.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kro.cmmn.PageInfo;
import org.kro.cmmn.ReplyVO;
import org.kro.dao.ReplyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/root-context.xml"})
public class ReplyDAOTest {
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void listPage(){
		PageInfo info = new PageInfo();
		info.setPage(2);
		
		List<ReplyVO> list = dao.list(2065, info);
		for(ReplyVO vo : list){
			System.out.println(vo.toString());
		}
	}

	@Test
	public void countTest(){
		System.out.println(dao.count(2065));
	}

}





