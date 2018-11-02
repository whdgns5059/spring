package kr.or.ddit.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	

	@RequestMapping("/hello.do")
	public String hello() {
		
		//viewName을 리턴
		//internalResourceViowResolver 설정에 의해
		//prefix _ viewName + suffix 위치의 리소스로 응답을 위임한다
		return "hello";
	}
	
	
	/*
	 * servlet doGet, doPost: 메소드 인자가 httpServletRequest, httpServletResponse
	 * 인자가 2개로 고정되어 있음
	 * Spring controller : 비교적 자유롭게 구성이 가능
	 * 				httpServletRequest, HttpServletResponse, HttpSession,
	 * 				ValueOject, 
	 * 				Model : view에서표현을 데이터를 저장(request와 거의 유사)
	 * 	
	 */
	@RequestMapping("/model")
	public String model(Model model) {
	
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		//servlet : request.setAttribute("rangers", rangers)
		model.addAttribute("rangers", rangers);
		
		return "hello";
	}
	
	@RequestMapping("/request")
	public String request(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
	
		model.addAttribute("userId", userId + "_attr");
		model.addAttribute("pass", pass + "_attr");
				
		logger.debug("userId : {}", userId);
		logger.debug("password : {}", pass);
		
		return "hello";
	}
	
	@RequestMapping("/vo")
	public String vo(UserVo userVo, Model model) {
		
		logger.debug("userVo : {} ", userVo );
		
		model.addAttribute("userVo", userVo);
		
		
		return "hello";
	}
	
	
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView() {

		ModelAndView mav = new ModelAndView();

		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		//model.addAttribute("rangers", rangers);와 동일
		mav.addObject("rangers", rangers);
		mav.setViewName("hello");
		
		return mav;
	}
	
	@RequestMapping("/void")
	public void voidMethod(HttpServletResponse resp) throws IOException {
		
		PrintWriter pw = resp.getWriter();
	
		pw.println("<html><h2>spring voidMethod</h2></html>");
		
	}
	
	
	
}
































