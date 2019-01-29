package org.kro.cmmn;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private PageInfo pageinfo;

	public PageMaker() {
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcDate();
	}

	private void calcDate(){
		endPage = (int)(Math.ceil(pageinfo.getPage() / (double) displayPageNum) * displayPageNum );
		startPage = (endPage - displayPageNum ) + 1;
		
		int tempEndPage = (int)(Math.ceil(totalCount) / (double)pageinfo.getPerPageNum());
		int tempEndPageEtc = (int)(Math.ceil(totalCount) % (double)pageinfo.getPerPageNum());
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
			if(tempEndPageEtc > 0){
				endPage++;
			}
		}
		
		prev = (startPage == 1) ? false:true;
		next = (endPage * pageinfo.getPerPageNum() >= totalCount) ? false:true;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public PageInfo getPageinfo() {
		return pageinfo;
	}

	public void setPageinfo(PageInfo pageinfo) {
		this.pageinfo = pageinfo;
	}
	
	public String makeQuery(int page){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", pageinfo.getPerPageNum())
				.build();
		return uri.toString();
	}
	
	public String makeSearch(int page){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", pageinfo.getPerPageNum())
				.queryParam("searchType", pageinfo.getSearchType())
				.queryParam("keyword", pageinfo.getKeyword())
				.build();
		return uri.toString();
				
	}
	
	
}
