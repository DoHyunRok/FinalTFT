package kr.co.fpj.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fpj.UserDAO.UserDAO;
import kr.co.fpj.UserVO.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO dao;
	@Override
	public int idcheck(String id) {
		return dao.registerCheck(id);
	}
	@Override
	public int join(UserVO vo) {
		System.out.println(":::join seImpl:::");
		return dao.join(vo);
	}
	@Override
	public int login(UserVO vo,HttpSession session) {
		System.out.println(":::login seImpl:::");
		return dao.login(session,vo);
	}
}
