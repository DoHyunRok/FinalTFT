package kr.co.fpj.bbscontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.fpj.CommentService.FreeCommentService;
import kr.co.fpj.Commentvo.FreeCommentVo;
import kr.co.fpj.bbsservice.freeservice;
import kr.co.fpj.bbsvo.freevo;

@Controller
public class HomeController {

	@Inject
	freeservice se;
	@Inject
	FreeCommentService cse;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
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
		String path = null;
		System.out.println(vo.getTitle());
		if(vo.getTitle()!= "") {
			vo.setTitle(vo.getTitle());
			vo.setWriter(vo.getWriter());
			vo.setContent(vo.getContent());
			se.write(vo);
			path = "free";
			System.out.println(":::True :::");
		}else {
			path ="redirect:freewrite.do";
			System.out.println(":::false::::");
		}
		return path;
	}
	@RequestMapping(value = "/freeview.do", method = RequestMethod.GET)
	public String getboard(freevo vo,Model model,FreeCommentVo cvo) {
		String path ="";
		List<freevo> board = se.getboard(vo);
		if(board != null) {
			model.addAttribute("board", board);
			List<FreeCommentVo> cboard = cse.ReplyView(vo.getSeq());
			System.out.println(cboard);
			model.addAttribute("cboard",cboard);
			se.updateCnt(vo);
			path = "freeview";
		}else {
			path = "free";
			System.out.println("::: 내용이없습니다 :::");
		}	
		return path;
	}
	@RequestMapping(value = "/boardcheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardcheck(HttpServletRequest req,Model model,freevo vo,String title) {
		System.out.println("::: board check :::");
		vo.setTitle(req.getParameter("title"));
		String cnt1 =null;
		
		if (vo.getTitle() != ""){
			cnt1 = "1";
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("cnt1",cnt1);
			System.out.println(":::집에가자:::");
		}else {
			cnt1 = "0";
			System.out.println(":::false 탐:::");
		}
		return cnt1;
	}
	@RequestMapping(value = "/champion.do", method = RequestMethod.GET)
	public String champion() {
		return "champion";
	}
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public String map() {
		return "Map";
	}
	
//	@RequestMapping(value = "/psort.do", method = RequestMethod.POST)
//	@ResponseBody
//	public ArrayList<freevo> psort(freevo vo,Model model) {
//		ArrayList<freevo> boardlist = null;
//		boardlist = se.psort(vo);
//		if(boardlist.isEmpty()) {
//			System.out.println("Miss");
//		}else {
//			model.addAttribute("boardlist",boardlist);
//			System.out.println(":::성공:::");
//			System.out.println(boardlist);
//		}
//		return boardlist;
//	}
	@RequestMapping(value = "/psort.do", method = RequestMethod.POST)
	public String psort(freevo vo,Model model) {
		ArrayList<freevo> boardlist = null;
		boardlist = se.psort(vo);
		if(boardlist.isEmpty()) {
			System.out.println("Miss");
		}else {
			model.addAttribute("boardlist",boardlist);
			System.out.println(":::성공:::");
			System.out.println(boardlist);
		}
		return "free";
	}
}
