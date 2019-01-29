package org.kro.dao;

import java.util.List;

import org.kro.cmmn.PageInfo;
import org.kro.cmmn.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(int bno, PageInfo info);
	public int create(ReplyVO vo);
	public int update(ReplyVO vo);
	public int delete(int rno);
	public int count(int bno);
	
}
