package org.kro.dao;

import java.util.List;
import java.util.Map;

import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;

public interface BoardDAO {
	
	public String getTime();
	public void viewCount(Map map);
	public List<BoardVO> listAll();
	public List<BoardVO> listPage(PageInfo info);
	public int insert(BoardVO vo);
	public BoardVO read(Map map);
	public int remove(Map map);
	public int modify(BoardVO vo);
	public int getTotalRowCount(PageInfo info);
	
}
