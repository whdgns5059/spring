package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserServiceTest extends ServiceDaoConfigTest {
	
	@Resource(name="userService")
	private UserServiceInf userService;
	
	@Test
	public void selectUserAllTest() {
		
		/***Given***/
		/***When***/
		List<UserVo> result = userService.selectUserAll();
		/***Then***/
		assertEquals(105, result.size());
	}

	@Test
	public void selectUserByUserIdTest() {
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo result = userService.selectUser(userId);
		
		/***Then***/
		assertEquals("브라운", result.getName());
	}

	@Test
	public void selectUserByUserVo() {
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		/***When***/
		
		UserVo result = userService.selectUser(userVo);
		
		/***Then***/
		assertEquals("브라운", result.getName());
	}
	@Test
	public void selectUserPageList(){
		
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(2);
		pageVo.setPageSize(10);

		/***When***/
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		List<UserVo> result = (List<UserVo>) resultMap.get("userList");
		int pageCnt = (Integer)resultMap.get("pageCnt");
		
		/***Then***/
		assertEquals(10, result.size());
		assertEquals(11, pageCnt);
	}
	
	@Test
	public void selectUserPageCountTest(){
		/***Given***/

		/***When***/
		int result = userService.getUserCnt();
		/***Then***/
		assertEquals(11, result);
	}
	
	
}
