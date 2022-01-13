package kr.co.fpj.UserController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.fpj.UserService.UserService;
import kr.co.fpj.UserVO.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService se;
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public int join(UserVO vo) {
		int result = 0;
		result = se.join(vo);
		return result;
	}
	 @RequestMapping(value = "/idcheck.do", method = RequestMethod.POST)
	 @ResponseBody
	    public Map<Object, Object> idcheck(@RequestBody String id) {
	        System.out.println(":::id check :::");
	        System.out.println(id);
	        int count = 0;
	        Map<Object, Object> map = new HashMap<Object, Object>();
	 
	        count = se.idcheck(id);
	        map.put("cnt", count);
	 
	        return map;
	    }
}
