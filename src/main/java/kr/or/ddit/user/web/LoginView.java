package kr.or.ddit.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.model.UserVo;

@Controller
@RequestMapping("/user")
public class LoginView {

	@RequestMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping("/loginProcess")
	public String loginProcess(UserVo userVo, Model model) {
		
		if(userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) {
			
			model.addAttribute("nowLogin", userVo);
			
			return "main";
		}else {
			return "login";
		}
		
		
	}
	
}
