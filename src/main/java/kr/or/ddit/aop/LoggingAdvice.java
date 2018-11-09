package kr.or.ddit.aop;

import javax.print.attribute.standard.JobOriginatingUserName;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* LogginAdvice.java
*
* @author pc17
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* pc17 최초 생성
* 공통의관심사(메소드 호출 로깅)를 담당하는 advice
*
* </pre>
*/
public class LoggingAdvice {
	
	private Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	//우리가 구현하는 비지니스 로직이 실행되기 전에
	//실행 되는 공통 로직
	public void beforeAdvice(JoinPoint jointPoint) {
		//joinPoint : 우리가 구현한 로직은 메소드
		//beforeAdvice가 먼저 호출 되고 joinPoint호출
		String methodName = jointPoint.getSignature().getName();
		String className = jointPoint.getTarget().getClass().getName();
		
		log.debug("BeforeclassName : {} ", className);
		log.debug("BeforemethodName : {} ", methodName);
		
	}
	
	public void afterAdvice(JoinPoint jointPoint) {
		//joinPoint : 우리가 구현한 로직은 메소드
		//beforeAdvice가 먼저 호출 되고 joinPoint호출
		String methodName = jointPoint.getSignature().getName();
		String className = jointPoint.getTarget().getClass().getName();
		
		log.debug("AfterclassName : {} ", className);
		log.debug("AftermethodName : {} ", methodName);
		
	}
	
	//비지니스 로직 전후로 다른 로직을 삽입
	public Object aroundAdvice(ProceedingJoinPoint jointPoint) throws Throwable {
		
		//실제 비지니스 메소드 실행 전
		long startTime = System.currentTimeMillis();
		
		//실제 비지니스 메소드 호출
		Object[] args = jointPoint.getArgs(); //비지니스 메소드 매개변수
		Object object = jointPoint.proceed(args); //비지니스 메소드 실행

		//실제 비지니스 메소드 실행 후
		long endTime = System.currentTimeMillis();
		
		log.debug("duration: {} ", endTime-startTime);
		
		
		return object;
	}
}
