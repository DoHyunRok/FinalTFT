package kr.co.fpj.bbscontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.fpj.CommentService.FreeCommentService;
import kr.co.fpj.Commentvo.FreeCommentVo;
import kr.co.fpj.bbsservice.freeservice;
import kr.co.fpj.bbsvo.PageVO;
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
	public String bbs1(Model model, HttpServletRequest req, PageVO pvo) {
		pvo.setCpage(10);
		System.out.println(pvo.getCpage());
		ArrayList<freevo> boardlist = se.boardList(pvo);
		if (boardlist != null) {
			model.addAttribute("boardlist", boardlist);
		} else {
			System.out.println(":::null:::");
		}

		return "free";
	}

	@RequestMapping(value = "/free.do", method = RequestMethod.POST)
	public ArrayList<freevo> bbs2(Model model, HttpServletRequest req, PageVO pvo) {
		ArrayList<freevo> boardlist = se.boardList(pvo);
		if (boardlist != null) {
			model.addAttribute("boardlist", boardlist);
		} else {
			System.out.println(":::null:::");
		}

		return boardlist;
	}

	@RequestMapping(value = "/freewrite.do", method = RequestMethod.GET)
	public String write() {
		System.out.println(":::write get:::");
		return "freewrite";
	}

	@RequestMapping(value = "/freewrite.do", method = RequestMethod.POST)
	public String write(freevo vo, Model model) {
		String path = null;
		System.out.println(vo.getTitle());
		if (vo.getTitle() != "") {
			vo.setTitle(vo.getTitle());
			vo.setWriter(vo.getWriter());
			vo.setContent(vo.getContent());
			se.write(vo);
			path = "free";
			System.out.println(":::True :::");
		} else {
			path = "redirect:freewrite.do";
			System.out.println(":::false::::");
		}
		return path;
	}

	@RequestMapping(value = "/freeview.do", method = RequestMethod.GET)
	public String getboard(freevo vo, Model model, FreeCommentVo cvo) {
		String path = "";
		List<freevo> board = se.getboard(vo);
		System.out.println(vo.getSeq());
		if (board != null) {
			model.addAttribute("board", board);
			List<FreeCommentVo> cboard = cse.ReplyView(vo.getSeq());
			System.out.println(cboard);
			model.addAttribute("cboard", cboard);
			se.updateCnt(vo);
			path = "freeview";
		} else {
			path = "free";
			System.out.println("::: 내용이없습니다 :::");
		}
		return path;
	}

	@RequestMapping(value = "/boardcheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String boardcheck(HttpServletRequest req, Model model, freevo vo, String title) {
		System.out.println("::: board check :::");
		vo.setTitle(req.getParameter("title"));
		String cnt1 = null;

		if (vo.getTitle() != "") {
			cnt1 = "1";
			Map<Object, Object> map = new HashMap<Object, Object>();
			map.put("cnt1", cnt1);
			System.out.println(":::집에가자:::");
		} else {
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
	@RequestMapping(value = "/BoardSearch.do", method = RequestMethod.POST)
	public String Searchbbs(@RequestParam(value = "SearchCategory", defaultValue = "") String sc,
			@RequestParam(value = "boardSearch", defaultValue = "", required = false) String bs, Model model, freevo vo,
			HttpServletRequest req, PageVO pvo) {
		ArrayList<freevo> boardlist = null;
		System.out.println(bs);
		System.out.println(sc);

		if (bs.equals(null)) {
			System.out.println(":::BS NULL:::");
			boardlist = se.boardList(pvo);
			model.addAttribute("boardlist", boardlist);
		} else if (sc.equals("title")) {
			System.out.println(":::제목검색:::");
			boardlist = se.searchTitle(bs);
			model.addAttribute("boardlist", boardlist);
		} else if (sc.equals("content")) {
			boardlist = se.searchContent(bs);
			model.addAttribute("boardlist", boardlist);
		} else {

		}

		return "free";
	}

	@RequestMapping(value = "/nextpage.do", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<freevo> nextpage(Model model, HttpServletRequest req, PageVO pvo, int cpage, String sorttype) {
		System.out.println(sorttype);
		ArrayList<freevo> boardlist = null;
		if (sorttype == null && req.getParameter("cpage") != null) {
			boardlist = se.nextpage(cpage);
		} else if (sorttype.equals("commentsort") && req.getParameter("cpage") != null) {
			boardlist = se.commentcntboardlist(pvo);
		} else if (sorttype.equals("regdatesort") && req.getParameter("cpage") != null) {
			boardlist = se.regboardlist(pvo);
		} else if (sorttype.equals("cntsort") && req.getParameter("cpage") != null) {
			boardlist = se.cntboardlist(pvo);
		}
		return boardlist;
	}

	@RequestMapping(value = "/cntsort.do", method = RequestMethod.POST)
	@ResponseBody
	public ArrayList<freevo> cntsort(Model model, HttpServletRequest req, String sorttype, PageVO pvo, int cpage) {
		ArrayList<freevo> boardlist = null;
		System.out.println(sorttype);
		System.out.println(req.getParameter("cpage"));
		if (sorttype == null && req.getParameter("cpage") != null) {
			boardlist = se.nextpage(cpage);
			model.addAttribute("boardlist", boardlist);
		} else if (sorttype.equals("commentsort") && req.getParameter("cpage") != null) {
			boardlist = se.commentcntboardlist(pvo);
			model.addAttribute("boardlist", boardlist);
		} else if (sorttype.equals("regsort") && req.getParameter("cpage") != null) {
			System.out.println(":::regsort:::");
			boardlist = se.regboardlist(pvo);
			model.addAttribute("boardlist", boardlist);
		} else if (sorttype.equals("cntsort") && req.getParameter("cpage") != null) {
			boardlist = se.cntboardlist(pvo);
			model.addAttribute("boardlist", boardlist);
		}
		return boardlist;
	}
	@RequestMapping(value="/test.do",method=RequestMethod.GET)
	public String idsearch(HttpServletRequest req) {
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("po"));
		return "Test";
	}
}
