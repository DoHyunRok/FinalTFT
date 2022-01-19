package kr.co.fpj.UserController;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.fpj.UserDAO.KakaoAPI;

@Controller
@SessionAttributes({"nickname","userId","access_Token"})

public class KakaoController {

	@Autowired
	private KakaoAPI kakao;

	@RequestMapping(value = "/login", produces="application/json;charset=UTF-8", method = RequestMethod.GET)
	public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
		System.out.println("#########" + code);
		HttpHeaders responseHeaders = new HttpHeaders(); responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String access_Token = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
		System.out.println("###access_Token#### : " + access_Token);
		System.out.println("###userInfo#### : " + userInfo.get("email"));
		System.out.println("###nickname#### : " + userInfo.get("nickname"));

		return "join";
	}
	
	
}
/*	@RequestMapping(value="/login" ,method = RequestMethod.GET)
	public String login(@RequestParam("code") String code, x`HttpSession session) {
		String access_Token = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
		System.out.println("code : "+ code);
		System.out.println("login Controller : " + userInfo);


		//    클占쏙옙占싱억옙트占쏙옙 占싱몌옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占실울옙 占쌔댐옙 占싱몌옙占싹곤옙 占쏙옙큰 占쏙옙占�
		if (userInfo.get("email") != null) {
			session.setAttribute("nickname",userInfo.get("nickname"));
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("access_Token", access_Token);
		}	
		return "loginafter";

	}




	@RequestMapping(value="/logout" , method = RequestMethod.GET)	
	public String logout(HttpSession session) {
		kakao.kakaoLogout((String)session.getAttribute("access_Token"));
		kakao.kakaoLogout((String)session.getAttribute("responseCode"));


		if (session.getAttribute("access_Token") != null) { 

			session.removeAttribute("access_Token");
			session.removeAttribute("refresh_token");
			session.removeAttribute("code");
		}
		System.out.println("�넗�겙�궘�젣");
		return "logout";
 */





