package kr.co.fpj.bbscontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.fpj.bbsservice.duoservice;
import kr.co.fpj.bbsvo.duovo;

@Controller
public class DuoController {
	
	@Autowired
	duoservice se;
	
	@RequestMapping(value = "/duo.do", method = RequestMethod.GET)
	public String bbs2(Model model) {
		ArrayList<duovo> boardlist = se.boardList();
		
		if(boardlist != null) {
			model.addAttribute("duoboard",boardlist);
		}
		return "duo";
	}
	@RequestMapping(value = "/duowrite.do", method = RequestMethod.POST)
	public String write(duovo vo,Model model) {
		System.out.println(":::write post:::");
		vo.setTitle(vo.getTitle());
		System.out.println(vo.getTitle());
		vo.setWriter(vo.getWriter());
		vo.setContent(vo.getContent());
		se.write(vo);
		return "redirect:/";
	}
	@RequestMapping(value = "/duowrite.do", method = RequestMethod.GET)
	public String write() {
		return "duowrite";
	}
	@RequestMapping(value = "/duoview.do", method = RequestMethod.GET)
	public String getboard(duovo vo,Model model) {
		System.out.println("::: 상세보기 :::");
		String path ="";
		List<duovo> board= se.getboard(vo);
		System.out.println(board);
		if(board != null) {
			model.addAttribute("board", board);
			se.updateCnt(vo);
			path = "freeview";
		}else {
			path = "free";
			System.out.println("::: 내용이없습니다 :::");
		}	
		return path;
	}
}
