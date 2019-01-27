package org.kro.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public String getTime() {
		return session.selectOne("board.getTime");
	}

	@Override
	public List<BoardVO> listAll() {
		return session.selectList("board.listAll");
	}

	@Override
	public int insert(BoardVO vo) {
		return session.insert("board.insert", vo);
	}

	@Override
	public BoardVO read(Map map) {
		return session.selectOne("board.read", map);
	}

	@Override
	public int remove(Map map) {
		return session.delete("board.remove", map);
	}

	@Override
	public void viewCount(Map map) {
		session.update("board.viewCountUp", map);
	}

	@Override
	public int modify(BoardVO vo) {
		return session.update("board.modify", vo);
	}

	@Override
	public List<BoardVO> listPage(PageInfo info) {
		return session.selectList("board.listPage", info);
	}

	@Override
	public int getTotalRowCount(PageInfo info) {
		return session.selectOne("board.getTotalRowCount", info);
	}


}
