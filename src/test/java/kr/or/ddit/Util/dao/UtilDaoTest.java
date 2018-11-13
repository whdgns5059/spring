package kr.or.ddit.Util.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.util.dao.UtilDaoInf;

public class UtilDaoTest extends ServiceDaoConfigTest{

	@Resource(name="utilDao")
	private UtilDaoInf utilDao;
	
	@Test
	public void makeMonthlyCalenderTest() {
		/***Given***/
		String ym = "201811";
		
		/***When***/
		int insertCnt = utilDao.makeMonthlyCalender(ym); 

		/***Then***/
		assertEquals(30, insertCnt);
	}

}
