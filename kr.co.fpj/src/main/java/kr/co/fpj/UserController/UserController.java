package kr.co.fpj.UserController;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.fpj.Encryption.LoginEncryption;
import kr.co.fpj.UserService.UserService;
import kr.co.fpj.UserVO.UserVO;

@Controller
public class UserController {
	@Autowired
	public UserService se;
	@Autowired
	
	public LoginEncryption encryption;
	
	HashMap<String, Object> keymap = new HashMap<>();
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		try {
			keymap = (HashMap<String, Object>) encryption.getKey().clone();
			encryption.clearKeyMap();
			session.setAttribute("publicKeyExponent",keymap.get("publicKeyExponent"));
			session.setAttribute("publicKeyModulus",keymap.get("publicKeyModulus"));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return "login";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request,Model model,UserVO vo,HttpSession session) {
		
		String encryptedPWD = request.getParameter("encryptedPWD");
		PrivateKey privatekey = (PrivateKey) keymap.get("privateKey");
		String userPWD=null;
		userPWD=encryption.decryptRsa(privatekey, encryptedPWD);
		vo.setId(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		System.out.println(userPWD);
		vo.setPassword(userPWD);
		int result = se.login(vo, session);
		if (result ==1) {
			System.out.println("login 완료");
		}else {
			System.out.println("login 실패");
		}
		
		return "redirect:free.do";
	}
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		try {
			keymap = (HashMap<String, Object>) encryption.getKey().clone();
			encryption.clearKeyMap();
			session.setAttribute("publicKeyExponent",keymap.get("publicKeyExponent"));
			session.setAttribute("publicKeyModulus",keymap.get("publicKeyModulus"));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return "join";
	}
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String join(UserVO vo,HttpServletRequest request, Model model) {
		String encryptedPWD = request.getParameter("encryptedPWD");
		PrivateKey privatekey = (PrivateKey) keymap.get("privateKey");
		String userPWD=null;
		userPWD=encryption.decryptRsa(privatekey, encryptedPWD);
		vo.setPassword(userPWD);
		System.out.println(":::암호는: "+userPWD+ "입니다.");
		se.join(vo);
		return "login";
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
	 @RequestMapping(value="/kakaologin" ,method= RequestMethod.GET)
		public String kakaologin() {
		 System.out.println(":::옴:::");
			return "redirect:/";

		}
}
