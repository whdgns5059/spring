package kr.or.ddit.exception;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileException extends Exception{
//NoFileException이 발생 할 경우 HTTP응답모드를 서버 내부에선 500이 아니라
//404 not found 응답코드로 대체
	
	@RequestMapping("/exception")
	public String view() {
		throw new ArithmeticException();
	}
	
	//Response status 테스트를 위한 url
	@RequestMapping("/responseStatus")
	public String responseStatus() throws NoFileException {
		
		ClassPathResource resource =  new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml");
		
		try {
			resource.getInputStream();
		} catch (IOException e) {
			throw new NoFileException();
		}
		
		return "error/arithmeticException";
		
	}

}
