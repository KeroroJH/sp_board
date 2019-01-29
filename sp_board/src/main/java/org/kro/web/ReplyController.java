package org.kro.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kro.cmmn.PageInfo;
import org.kro.cmmn.PageMaker;
import org.kro.cmmn.ReplyVO;
import org.kro.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies/")
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Integer> create(@RequestBody ReplyVO vo){
		ResponseEntity<Integer> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.create(vo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> list(@PathVariable("bno") int bno, @PathVariable("page") int page){
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			PageInfo info = new PageInfo();
			info.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setPageinfo(info);
			pageMaker.setTotalCount(service.count(bno));
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", service.list(bno, info));
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.PATCH)
	public ResponseEntity<Integer> update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo){
		ResponseEntity<Integer> entity = null;
		vo.setRno(rno);
		try {
			entity = new ResponseEntity<>(service.update(vo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable("rno") int rno){
		ResponseEntity<Integer> entity = null;
		try {
			entity = new ResponseEntity<>(service.delete(rno), HttpStatus.OK );
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
