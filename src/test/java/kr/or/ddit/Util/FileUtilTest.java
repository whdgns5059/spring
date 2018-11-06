package kr.or.ddit.Util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import kr.or.ddit.file.util.FileUtil;
import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.test.ServiceDaoConfigTest;


public class FileUtilTest{

	
	@Test
	public void getFileExtTest() {
		
		/***Given***/
		String fileName = "sally.pnaag";
		/***When***/
		String ext = FileUtil.getFileExt(fileName);
		
		
		/***Then***/
		assertEquals(".pnaag", ext);
	}

	@Test
	public void getFileExtTest2() {
		
		/***Given***/
		String fileName = "salafeafasefsdfly";
		/***When***/
		String ext = FileUtil.getFileExt(fileName);

		/***Then***/
		assertEquals("", ext);
	}
	
	@Test
	public void getFileExtTest3() {
		
		/***Given***/
		String fileName = ".gitignore";
		/***When***/
		String ext = FileUtil.getFileExt(fileName);

		/***Then***/
		assertEquals(".gitignore", ext);
	}
	
}
