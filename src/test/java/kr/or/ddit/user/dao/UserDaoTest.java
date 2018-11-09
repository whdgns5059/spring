package kr.or.ddit.user.dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;


public class UserDaoTest  extends ServiceDaoConfigTest{

	@Resource(name="userDao")
	private UserDaoInf userDao;
	private final String TEST_USER_ID = "testUser3";
	
	
	@Test
	public void selectUserAllTest(){
		/***Given***/
		/***When***/
		List<UserVo> result = userDao.selectUserAll();
		
		/***Then***/
		assertEquals(105, result.size());
	}
	
	@Test
	public void selectUserTest(){
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo userVo = userDao.selectUser(userId);
		/***Then***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getName());
	}
	
	@Test
	public void selectUserByVoTest(){
		
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setName("브라운");
		/***When***/
		UserVo result = userDao.selectUser(userVo);
		/***Then***/
		assertNotNull(result);
		assertEquals("brown", result.getUserId());
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		assertEquals("18/08/08", format.format(result.getBirth()));
		
	}
	
	@Test
	public void selectUserPageList(){
		
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(2);
		pageVo.setPageSize(10);

		/***When***/
		List<UserVo> result = userDao.selectUserPageList(pageVo);
		
		/***Then***/
		for(UserVo userVo : result){
			System.out.println(userVo.getRnum());
		}
		assertEquals(10, result.size());
		
		
	}
	
	/**
	* Method : getUserCntTest
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 전체 조회 테스트
	 */
	@Test
	public void getUserCntTest(){
		/***Given***/

		/***When***/
		int count = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, count);
		
		
	}
	@Test
	public void insertUserTest(){
		
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setPass("testPass");
		userVo.setName("testName");
		userVo.setAddr1("대전 중구 대흥동 76");
		userVo.setAddr2("2층 대덕인재개발원");
		GregorianCalendar gc = new GregorianCalendar(2018, 10, 20);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setZipcd("34940");
		userVo.setEmail("test@gmail.com");
		userVo.setTel("010-1234-1234");
		

		/***When***/
		int result = userDao.insertUser(userVo);
		
		/***Then***/
		assertEquals(1, result);
		
		
		int delResult = userDao.deleteUser(TEST_USER_ID);
		assertEquals(0, delResult);
		
	}
	
	
	@Test
	public void updateUserTest(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("usertest1");
		userVo.setPass("testPass");
		userVo.setName("업데이트성공");
		userVo.setAddr1("대전 중구 대흥동 76");
		userVo.setAddr2("2층 대덕인재개발원");
		GregorianCalendar gc = new GregorianCalendar(2018, 10, 20);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setZipcd("34940");
		userVo.setEmail("test@gmail.com");
		userVo.setTel("010-1234-1234");
		
		System.out.println(userVo);
		/***When***/
		int result = userDao.updateUser(userVo);
		
		/***Then***/
		assertEquals(1, result);
		
	}
	
}
