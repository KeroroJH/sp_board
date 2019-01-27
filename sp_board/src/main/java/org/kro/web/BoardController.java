package org.kro.web;

import java.util.Map;

import org.kro.cmmn.BoardVO;
import org.kro.cmmn.PageInfo;
import org.kro.cmmn.PageMaker;
import org.kro.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value="listAll", method = RequestMethod.GET)
	public String listAll(Model model){
		logger.info("listAll .. ");
		//model.addAttribute("list", service.listAll());
		return "redirect:listPage";
	}
	
	@RequestMapping(value="listPage", method = RequestMethod.GET)
	public void listPage(Model model,@ModelAttribute("pageinfo") PageInfo info){
		logger.info("listPage" + info.getPage());
		model.addAttribute("list", service.listPage(info));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageinfo(info);
		pageMaker.setTotalCount(service.getTotalRowcount(info));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public void register(){
		logger.info("register .. ");
	}
	
	@RequestMapping("read")
	public void read(@RequestParam Map map, Model model,@ModelAttribute("pageinfo") PageInfo info){
		logger.info("readPage .. " + map.get("bno"));
		model.addAttribute(service.read(map));
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public void readFormodify(@RequestParam Map map, Model model){
		logger.info("readForModify .. " + map.get("bno"));
		model.addAttribute(service.read(map));
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardVO vo, RedirectAttributes rda){
		logger.info("modify .. "+ vo.getBno());
		 rda.addFlashAttribute("msg", service.modify(vo));
		return "redirect:listAll";
	}
	
	@RequestMapping(value="remove", method = RequestMethod.POST)
	public @ResponseBody int remove(@RequestParam Map map){
		logger.info("remove .. " + map.get("bno"));
		return service.remove(map);
	}
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String insert(BoardVO vo){
		logger.info("insert .. ");
		int result = service.insert(vo);
		return "redirect:/board/listAll";
	}
}
