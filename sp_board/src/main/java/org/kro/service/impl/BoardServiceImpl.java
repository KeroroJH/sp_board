package org.kro.service.impl;

import java.util.List;
import java.util.Map;

import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;
import org.kro.dao.BoardDAO;
import org.kro.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardVO> listAll() {
		return dao.listAll();
	}

	@Override
	public int insert(BoardVO vo) {
		return dao.insert(vo);
	}

	@Override
	public BoardVO read(Map map) {
		dao.viewCount(map);
		return dao.read(map);
	}

	@Override
	public int remove(Map map) {
		return dao.remove(map);
	}

	@Override
	public int modify(BoardVO vo) {
		return dao.modify(vo);
	}

	@Override
	public List<BoardVO> listPage(PageInfo info) {
		return dao.listPage(info);
	}

	@Override
	public int getTotalRowcount(PageInfo info) {
		return dao.getTotalRowCount(info);
	}

}
