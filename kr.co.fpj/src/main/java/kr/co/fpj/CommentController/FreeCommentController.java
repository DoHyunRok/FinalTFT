package kr.co.fpj.CommentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.fpj.CommentService.FreeCommentService;
import kr.co.fpj.Commentvo.FreeCommentVo;
import kr.co.fpj.bbsvo.freevo;


@Controller
public class FreeCommentController {
	@Autowired
	FreeCommentService se;
	@RequestMapping(value = "/commentinsert.do", method = RequestMethod.POST)
	public String commentwrite(FreeCommentVo vo,freevo fvo) {
		vo.setWriter(vo.getWriter());
		vo.setContent(vo.getContent());
		vo.setRegdate(vo.getRegdate());
		vo.setBseq(vo.getBseq());
		se.commentcount(vo.getBseq());
		int rs = se.WriteComment(vo);
		String path = null;
		if(rs != -2) {
			System.out.println(":::댓글 작성 완료:::");
			path = "redirect:freeview.do?seq="+vo.getBseq();
		}else {
			System.out.println(":::댓글 작성 실패:::");
			path = "free";
		}
		
		
		return path;
		
	}
}
