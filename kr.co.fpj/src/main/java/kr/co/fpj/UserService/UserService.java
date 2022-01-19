package kr.co.fpj.UserService;

import javax.servlet.http.HttpSession;

import kr.co.fpj.UserVO.UserVO;

public interface UserService {

	int idcheck(String id);

	int join(UserVO vo);

	int login(UserVO vo, HttpSession session);

}
