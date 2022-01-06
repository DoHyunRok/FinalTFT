package kr.co.fpj.bbscontroller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.fpj.bbsservice.freeservice;
import kr.co.fpj.bbsvo.freevo;

@Controller
public class HomeController {

	@Autowired
	freeservice se;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/free.do", method = RequestMethod.GET)
	public String bbs1(Model model) {
		ArrayList<freevo> boardlist = se.boardList();
		
		if(boardlist != null) {
			model.addAttribute("boardlist",boardlist);
		}
		return "free";
	}
	@RequestMapping(value = "/freewrite.do", method = RequestMethod.GET)
	public String write() {
		System.out.println(":::write get:::");
		return "freewrite";
	}
	@RequestMapping(value = "/freewrite.do", method = RequestMethod.POST)
	public String write(freevo vo,Model model) {
		System.out.println(":::write post:::");
		vo.setTitle(vo.getTitle());
		System.out.println(vo.getTitle());
		vo.setWriter(vo.getWriter());
		vo.setContent(vo.getContent());
		int board = se.write(vo);
		return "redirect:/";
	}
	@RequestMapping(value = "/freeview.do", method = RequestMethod.GET)
	public String getboard(freevo vo,Model model) {
		System.out.println("::: 상세보기 :::");
		String path ="";
		List board = se.getboard(vo);
		System.out.println(board);
		if(board != null) {
			model.addAttribute("board", board);
			int rs = se.updateCnt(vo);
			path = "freeview";
		}else {
			path = "free";
			System.out.println("::: 내용이없습니다 :::");
		}	
		return path;
	}
	@RequestMapping(value = "/boardcheck.do", method = RequestMethod.POST)
	public String boardcheck(HttpServletRequest req,Model model,freevo vo,String title) {
		System.out.println("::: board check :::");
		vo.setTitle(req.getParameter("title"));
		int cnt1 =0;
		
		if (vo.getTitle() != null || vo.getContent() != null){
			cnt1 = 1;
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("cnt1",cnt1);
			System.out.println(":::집에가자:::");
			System.out.println(cnt1);
		}else {
			cnt1 = 0;
			System.out.println(":::false 탐:::");
			System.out.println(cnt1);
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/champion.do", method = RequestMethod.GET)
	public String champion() {
		return "champion";
	}
	@RequestMapping(value = "/sidebar.do", method = RequestMethod.GET)
	public String sidebar() {
		return "sidebar";
	}
}
