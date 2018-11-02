package kr.or.ddit.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;

@Controller
@RequestMapping("/user")
public class LoginView {

	@RequestMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(UserVo userVo, Model model) {
		
		if(userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) {
			
			model.addAttribute("nowLogin", userVo);
			
			return "main";
		}else {
			return "login";
		}
		
		
	}
	
}
