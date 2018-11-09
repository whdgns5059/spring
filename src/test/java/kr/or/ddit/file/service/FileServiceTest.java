package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoConfigTest;

public class FileServiceTest extends ServiceDaoConfigTest{

	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Test
	public void FileServiceDaoTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("a460abcf-b856-404a-97f9-ced0b4e5aasdf");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSrpring\\upload");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		
		/***When***/
		int insertCnt = fileService.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}
