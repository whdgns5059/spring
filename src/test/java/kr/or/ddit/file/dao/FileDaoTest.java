package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoConfigTest;

public class FileDaoTest extends ServiceDaoConfigTest{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : 파일입력 테스트
	*/
	@Test
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("a460abcf-b856-404a-97f9-ced0b4e5aasdf");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSrpring\\upload");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		
		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	
	}

}
