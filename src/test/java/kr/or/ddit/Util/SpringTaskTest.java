package kr.or.ddit.Util;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.util.SpringTask;

public class SpringTaskTest extends ServiceDaoConfigTest {

	
	@Resource(name="springTask")
	private SpringTask springTask;
	
	@Test
	public void makeMonthlyCalenerTest() {
		/***Given***/
		
		/***When***/
		springTask.makeMonthlyCalender();
		
		/***Then***/
	}
	
	
	@Test
	public void makeDaily()	{
		/***Given***/
		
		/***When***/
		int result = springTask.makeDaily();
		
		/***Then***/
		assertEquals(66, result);
	}

}
