package kr.co.fpj.UserService;

import kr.co.fpj.UserVO.UserVO;

public interface UserService {

	int idcheck(String id);

	int join(UserVO vo);

}
