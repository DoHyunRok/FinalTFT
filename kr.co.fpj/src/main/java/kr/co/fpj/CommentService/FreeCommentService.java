package kr.co.fpj.CommentService;

import java.util.ArrayList;

import kr.co.fpj.Commentvo.FreeCommentVo;

public interface FreeCommentService {

	int WriteComment(FreeCommentVo vo);

	ArrayList<FreeCommentVo> ReplyView(int seq);

}
