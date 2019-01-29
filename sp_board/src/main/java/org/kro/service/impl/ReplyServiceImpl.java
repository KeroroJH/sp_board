package org.kro.service.impl;

import java.util.List;

import org.kro.cmmn.PageInfo;
import org.kro.cmmn.ReplyVO;
import org.kro.dao.ReplyDAO;
import org.kro.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;

	@Override
	public List<ReplyVO> list(int bno, PageInfo info) {
		return dao.list(bno, info);
	}

	@Override
	public int create(ReplyVO vo) {
		return dao.create(vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(int rno) {
		return dao.delete(rno);
	}

	@Override
	public int count(int bno) {
		return dao.count(bno);
	}

}
