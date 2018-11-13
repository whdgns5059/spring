package kr.or.ddit.rangers.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.rangers.model.RangerVo;
import kr.or.ddit.test.ServiceDaoConfigTest;

public class RangersDaoTest extends ServiceDaoConfigTest{
	
	
	@Resource(name="rangersDao")
	private RangersDaoInf rangersDao;
	
	

	

	/**
	* Method : selectAllRangersTest
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : 레인저스 정보 전체조회
	*/
	@Test
	public void selectAllRangersTest() {
		/***Given***/
		
		/***When***/
		List<RangerVo> rangers = rangersDao.selectAllRangers();

		/***Then***/
		assertEquals(3, rangers.size());
	}
	
	
	@Test
	public void insertRangerTest() {
		/***Given***/
		RangerVo ranger = new RangerVo();
		ranger.setRangersId("moon");
		ranger.setName("문");

		/***When***/
		int insertCnt = rangersDao.insertRanger(ranger);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}
