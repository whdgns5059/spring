package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import oracle.jdbc.proxy.annotation.Methods;

@Controller
@RequestMapping("/user")
public class UserController {

	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userService")
	private UserServiceInf userService;
	
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
	
	/**
	* Method : userAllList
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {
		
		//userService에서 사용자 전체 정보 조회
		List<UserVo> userList = userService.selectUserAll();
		
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
	}
	
	@RequestMapping("/userPageList")
	public String userPageList(Model model, PageVo pageVo) {
		
		//userService생성 => 주입 받으므로 필요없음
		
		//service의 selectUserPageList를 호출하기 위해 pageVo가 필요함'
		//request에서 파라미터를 받을 필요 없에 매개변수에 PageVo 선언한다
		
		//페이지 리스트 가져오기

		//Model객체에 가져온 값을 저장
		
		return "/user/userPagingList";
	}
	
	
	@RequestMapping("/userPageListAjax")
	public String userPageListAjax(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);

		model.addAllAttributes(resultMap);
		
		//응답을 json으로..
		return "jsonView";
	}
	
	
	//ajax 응답을 json이 아닌 html로 보냄
	@RequestMapping("/userPageListAjaxHtml")
	public String userPageListAjaxHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);

		model.addAllAttributes(resultMap);
		
		return "user/pageListHtml";
	}
	
	@RequestMapping("/userPaginationHtml")
	public String userPaginationHtml(Model model, PageVo pageVo) {
		
		logger.debug("pageVo : {}, {} ", pageVo.getPage(), pageVo.getPageSize());
		
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		
		
		model.addAllAttributes(resultMap);
		
		return "user/userPaginationHtml";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId") String userId, Model model) {
		
		//userId 파라미터 받기(@RequestParam 매개변수로 선언)

		//사용자 정보 조회
		UserVo userVo = userService.selectUser(userId);
		
		//조회한 정보를, 속성에 저장
		model.addAttribute("userVo",userVo);
		
		return "user/userDetail";
	}
	
	@RequestMapping(value="/userForm", method={RequestMethod.GET})
	public String userFormView() {
		return "user/userForm";
	}
	
	@RequestMapping(value="/userForm", method= {RequestMethod.POST})
	public String userForm(@RequestPart("profilePic") MultipartFile part
						, HttpServletRequest request, UserVo userVo) {
		
		//인코딩은 필터에서 해주므로 필요없음
		
		
		try {
			//파일 쓰기
			if(part.getSize() > 0) {
				//Part 객체는 @RequsetPart로 선언
				//파일 이름 가져오기 getOriginal... 으로 가능
				String fileName = part.getOriginalFilename();
				//파일 경로가져오기
				String path = request.getServletContext().getRealPath("/profile");
			
				//가져온 userVo에서 profile의 상대경로 저장
				userVo.setProfile("/profile/" + fileName);
				
				part.transferTo(new File(path + File.separator + fileName));
			}else {
				userVo.setProfile("");
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		
		//forward가 아니라 redirect 방식으로 보냄 
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
	
	@RequestMapping(value="/userUpdate", method= {RequestMethod.GET})
	public String userUpdate(@RequestParam("userId") String userId, Model model) {
		
		UserVo userVo = userService.selectUser(userId);
		model.addAttribute(userVo);
		
		return "user/userUpdateForm";
	}
	
	@RequestMapping(value="/userUpdate", method= {RequestMethod.POST})
	public String userUpdate(@RequestPart("profilePic") MultipartFile part,
							HttpServletRequest request, UserVo userVo) {
		
		//사용자 정보 받기 UserVo 에 담겨옴
		//Part는 multiPartFile 로 받아왔음
		
		
		try {
			//파일명 추출(originalName)
			String fileName = part.getOriginalFilename();
			//파일 경로
			String path = request.getServletContext().getRealPath("/profile");

			//프로필 사진 쓰고, userVo에 담기
			part.transferTo(new File(path + File.separator + fileName));
			userVo.setProfile("/profile/" + fileName);

		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//정보 담겨져있음..
		//타입 UserVo에서 @DateTimeFormat으로 변환됨
		
		//DB에 업데이트
		userService.updateUser(userVo);
		
		
		return "redirect:/user/userDetail?userId="+userVo.getUserId();
	}
	
}































