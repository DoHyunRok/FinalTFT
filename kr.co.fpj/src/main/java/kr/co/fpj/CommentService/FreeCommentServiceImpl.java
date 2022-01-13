package kr.co.fpj.CommentService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.CommentDAO.FreeCommentDAO;
import kr.co.fpj.Commentvo.FreeCommentVo;
@Service
public class FreeCommentServiceImpl implements FreeCommentService {
	
	@Autowired
	FreeCommentDAO dao;
	
	@Override
	public int WriteComment(FreeCommentVo vo) {
		return dao.insertreply(vo);
	}
	@Override
	public ArrayList<FreeCommentVo> ReplyView(int seq){
		System.out.println(":::ReplyView se:::");
		return dao.replyview(seq);
	}
}
