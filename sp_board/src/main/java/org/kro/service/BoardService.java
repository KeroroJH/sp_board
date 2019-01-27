package org.kro.service;

import java.util.List;
import java.util.Map;

import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;

public interface BoardService {
	public List<BoardVO> listAll();
	public List<BoardVO> listPage(PageInfo info);
	public int insert(BoardVO vo);
	public BoardVO read(Map map);
	public int remove(Map map);
	public int modify(BoardVO bo);
	public int getTotalRowcount(PageInfo info);
}
