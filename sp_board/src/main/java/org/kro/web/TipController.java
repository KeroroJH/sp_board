package org.kro.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kro.cmmn.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TipController {
	private static final Logger logger = LoggerFactory.getLogger(TipController.class);
	
	@RequestMapping("/doA") // void 타입은  @RequestMapping()이름과 동일하게 view로 전달되다
	public void doAvoid(){
		logger.info("doAvoid is Called ..");
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/doApost") //Request 메소드 지정하여 받기
	public void doApost(){
		logger.info("doApost is Called ..");
	}
	
	@RequestMapping("/doB") //HttpServletRequest 객체에서 파라미터를 수동으로 받아서 , Model에 수동으로 넣기
	public String doB(HttpServletRequest req, Model model){
		logger.info("doB is Called ..");
		String msg = req.getParameter("msg");
		model.addAttribute("msg", msg);
		return "/return";
	}
	
	@RequestMapping("/doC") // 파라미터 msg값을 msg변수에 넣고 , Model에 수동으로 넣기 (단 파라미터가 널이면 오류)
	public String doC(@RequestParam("msg") String msg, Model model){
		logger.info("doC is Called .." + msg);
		model.addAttribute("msg", msg);
		return "/return";
	}
	
	@RequestMapping("/doD") //파라미터 msg 값을 자동으로 Model에 넣기 (파라미터가 널이어도 오류 안남)
	public String doD(@ModelAttribute("msg") String msg){
		logger.info("doD is Called ..");
		return "/return";
	}
	
	@RequestMapping("/doE") // VO객체와 request파라미터항목들이 일치할시 해당 VO로 바로 받아서 Model에 넣을수 있다 /doE?name=keroro&price=4344
	public void doE(ProductVO productVO){
		logger.info("doE is Called ..");
	}
	
	@RequestMapping("/doF") // ModelAndView 로 view설정 및 Model 설정을 후에 할수있다 
	public ModelAndView doF(ModelAndView mv){
		logger.info("doF is Called ..");
		mv.setViewName("/doE");
		ProductVO vo = new ProductVO("keroro", (double) 3453);
		mv.addObject(vo);
		return mv;
	}
	
	@RequestMapping("/doG") // spring에서 제공하는 리다이렉트 시 추가로 데이터 전송 가능
	public String doG(RedirectAttributes rda){
		logger.info("doG is called .. ");
		rda.addFlashAttribute("msg"," redirect on doG");
		return "redirect:/doD";
	}
	
	
	@RequestMapping("/doH") // jsp에서 부터 사용된 방법 리다이렉트
	public void doG(HttpServletResponse res) throws IOException{
		logger.info("doH is called .. ");
		res.sendRedirect("/doD?msg=redirect_on_doH_jsp");
	}
	
	@RequestMapping("/doJSON") // JSON 타입으로 리턴을 할때 @ResponseBody 사용 [ jackson-databind 라이브러리 의존 ]
	public @ResponseBody ProductVO doJSON(){
		ProductVO vo = new ProductVO("jsonn", (double) 234234);
		return vo;
		
	}

}
