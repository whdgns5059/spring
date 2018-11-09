package kr.or.ddit.user.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator{
	
	private Logger logger = LoggerFactory.getLogger(UserVoValidator.class);
	
	//메소드 인자로 들어온 clazz 객체가 UserVo로부터 생성 가능한지 판단
	@Override
	public boolean supports(Class<?> clazz) {
		return UserVo.class.isAssignableFrom(clazz);
	}

	//실제 검증로직(값이 비어잇는가?, 글자수 제한, 정규식, 전화번호 포멧등..)
	@Override
	public void validate(Object target, Errors errors) {
		
		//target : validate 대상객체
		UserVo userVo = (UserVo)target;
		
		if(userVo.getUserId() == null || userVo.getUserId().equals("")) {
			logger.debug("validate userId");
			errors.rejectValue("userId", "required");
		}
		//pass의 길이가 5보다 작으면 error:legnthNotEnough
		if(userVo.getPass().length() < 5) { 
			logger.debug("validate pass");
			errors.rejectValue("pass", "lengthNotEnough");
		}
		//사용자 이름이 없을떄
		if(userVo.getName() == null || userVo.getName().equals("")) {
			logger.debug("validate name");
			errors.rejectValue("name", "required");
		}
		
	}

}
