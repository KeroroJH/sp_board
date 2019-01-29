package org.kro.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kro.cmmn.PageInfo;
import org.kro.cmmn.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<ReplyVO> list(int bno, PageInfo info) {
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("info", info);
		return session.selectList("reply.list", map);
	}

	@Override
	public int create(ReplyVO vo) {
		return session.insert("reply.create", vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return session.update("reply.update", vo);
	}

	@Override
	public int delete(int rno) {
		return session.delete("reply.delete", rno);
	}

	@Override
	public int count(int bno) {
		return session.selectOne("reply.countBybno", bno);
	}
	
}
