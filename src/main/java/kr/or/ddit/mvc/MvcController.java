package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

@Controller
@SessionAttributes("rangers")
public class MvcController {
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

	//@RequestMapping이
	//붙은 메소드가 실행되기 전에 먼저 실행됨
	//해당 컨트롤러에서 공통적으로 사용될 속성이 있을 경우
	//중복을 피하기 위해 @ModelAttribute 어노테이션을 적용한
	//메소드를 통해 코드 중복을 막을 수 있음

	
	
	@ModelAttribute(value="rangers")
	public List<String> setup() {
		
		logger.debug("{}", "setUp");
		
		List<String> rangers = new ArrayList<>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
//		model.addAttribute("rangers", rangers);
		return rangers;
		
		
	}
	
	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
	
		for(String str : rangers) {
			logger.debug("ranger : {}",str);
		}

		rangers.add("james");
		
		for(String str : rangers) {
			logger.debug("ranger : {}",str);
		}
		return "mvc/view";
	}
	
	
	@RequestMapping("/mvc/{libcd}")
	public String pathvariable(@PathVariable("libcd") String libcd) {
		logger.debug("libcd : {}", libcd);
		return "mvc/view";
	}
	
	
	//fileupload 테스트를 위한 view(get)
	@RequestMapping(value= {"/mvc/fileupload"}, method= {RequestMethod.GET})
	public String fileuploadView(){
		return "mvc/fileuploadView";
	}
	
	//fileupload를 처리하기위한 controller method(post)
	@RequestMapping(value= {"/mvc/fileupload"}, method= {RequestMethod.POST})
	public String fileupload(@RequestPart("uploadFile") MultipartFile part,
							@RequestParam("userId") String userId) {
		
		logger.debug("requestParam : {} ", userId);

		logger.debug("partSize = {}", part.getSize());
		logger.debug("fileName : {}", part.getOriginalFilename());

		//part.transferTo의 인자가 될 File 객체 생성
		//파일명이 같으면 충돌이 나므로 유니크한 임의의 파일명을 생성한다
		//UUID를 이용
		//업로드 경로 D:\\A_TeachingMaterial\\6.JspSrpring\\upload
		String path = "D:\\A_TeachingMaterial\\6.JspSrpring\\upload";
		String originalFileName = part.getOriginalFilename(); //오리지널 파일명
		String fileExt = FileUtil.getFileExt(originalFileName); //파일 확장자
		String fileName = UUID.randomUUID().toString()  + fileExt; //충돌 방지를 위한 임의의 파일명
		
		File file = new File(path + File.separator + fileName);
		

		FileVo fileVo = new FileVo();
		fileVo.setFile_name(fileName);
		fileVo.setFile_path(path);
		fileVo.setOrg_file_name(originalFileName);
		fileVo.setFile_ext(fileExt);
		
		logger.debug("fileVo : {}", fileVo);
		
		try {
			//정해진 path에 업로드 파일을 작성
			if(part.getSize() > 0) {
				part.transferTo(file);
				
				//데이터 베이스에 첨부파일 정보저장
				//1. fileService
				//2. 로직호출
				int insertCnt = fileService.insertFile(fileVo);
			}
			
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "mvc/fileuploadView";
	}
	
	
	
}