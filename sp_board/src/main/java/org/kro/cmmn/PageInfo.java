package org.kro.cmmn;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageInfo {
	private int page;
	private int perPageNum;
	
	private String keyword;
	private String searchType;
	
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public PageInfo(){
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0){
			page = 1;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 200 ){
			perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getStartNum(){
		return (this.page -1 ) * this.perPageNum;
	}
	
	public String makeQueryUri(){
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", this.page)
				.queryParam("perPageNum", this.perPageNum)
				.queryParam("keyword", this.keyword)
				.queryParam("searchType", this.searchType)
				.build();
		return uri.toString();
	}

	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", perPageNum=" + perPageNum + ", keyword=" + keyword + ", searchType="
				+ searchType + "]";
	}

	
}
