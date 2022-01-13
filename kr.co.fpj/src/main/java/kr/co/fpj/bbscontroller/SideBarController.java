package kr.co.fpj.bbscontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.fpj.bbsservice.sidebar;
import kr.co.fpj.bbsvo.sidebarvo;


@Controller
public class SideBarController {
	@Autowired
	sidebar se;
	@RequestMapping(value = "/sidebar.do", method = RequestMethod.GET)
		public String bbs1(Model model) {
			ArrayList<sidebarvo> boardlist = se.boardList();
			
			if(boardlist != null) {
				model.addAttribute("sideboard",boardlist);
				System.out.println(boardlist);
			}
			return "sidebar";
		}
	@RequestMapping(value = "/sidebar.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<sidebarvo> bbs2(Model model,@RequestParam(value="champname",defaultValue = "",required =false) String champname,sidebarvo vo) {
 		ArrayList<sidebarvo> boardlist = null;
		if(vo.getChampname() != null) {
			vo.setChampname(champname);
			boardlist = se.searchboard(vo);
			if(boardlist.isEmpty()) {
				System.out.println("챔프가 없습니다.");
			}else {
				model.addAttribute("sideboard",boardlist);
				System.out.println(":::성공:::");
				System.out.println(boardlist);
			}
		}else {
			System.out.println(":::실패:::");
			boardlist = se.boardList();
			model.addAttribute("sideboard",boardlist);
			System.out.println(boardlist);
		}
		return boardlist;
	}
}