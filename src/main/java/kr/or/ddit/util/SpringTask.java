package kr.or.ddit.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.dao.UtilDaoInf;

public class SpringTask {

	@Resource(name="utilDao")
	private UtilDaoInf utilDao;
	
	
	private Logger logger = LoggerFactory.getLogger(SpringTask.class);
	
	public void logging() {
		logger.debug(" LogTask.logging() ");
	}
	
	/**
	* Method : makeMonthlyCalender
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : 매달 마지막날 월 단위 달력 생성
	* 이 메소드가 실행되는 마지막 시넘은 매달 마지막날.
	* 다음달 년월 파라미터를 생성하여 실행(ex 20181130 실행 -> 201812)
	*/
	public void makeMonthlyCalender() {

		logger.debug("YearMonth : {}", "test");

		//내일 날짜
		GregorianCalendar gc = new GregorianCalendar(Locale.KOREA);
		gc.add(GregorianCalendar.DAY_OF_MONTH, 1);

		//date --> String(yyyy-MM)으로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ym = sdf.format(gc.getTime());
		
		logger.debug("YearMonth : {}", ym);
		
		utilDao.makeMonthlyCalender(ym);
	}

	public int makeDaily() {
		
		logger.debug("Dayly Start");
		
		GregorianCalendar gc = new GregorianCalendar(Locale.KOREA);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ym = sdf.format(gc.getTime());
		
		logger.debug("ym : {}" , ym);
		
		return utilDao.makeDaily(ym);
		
		
	}
	
	
	
}
