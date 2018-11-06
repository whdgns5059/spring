package kr.or.ddit.hello;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml", 
								"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration	// spring ioc 컨테이너 구성을 web 환경에 맞게 구성
public class HelloControllerTest {

	Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	@Autowired
	private WebApplicationContext ctx; //spring ioc container
	
	private MockMvc mockMvc; //dispatcher servlet (front controller)
	
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	
	
	@Test
	public void helloTest() throws Exception {
		
		/***Given***/
		
		/***When***/
		//dispatcher servlet으로 요청 전송
		MvcResult mvcResult = mockMvc.perform(get("/hello/hello.do")).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("hello", mav.getViewName());
		
	}
	
	@Test
	public void modelTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/model")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		@SuppressWarnings("unchecked")
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		//mav.getModelMap().get("rangers");
		
		
		for(String str : rangers) {
			logger.debug("ranger : {} ", str);
		}
		
		/***Then***/
		//1. view 이름
		assertEquals("hello", viewName);
		//2. rangers 속성(model)
		assertEquals(3, rangers.size());
			
		
	}	

	
	@Test
	public void requestTest() throws Exception   {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/request")
							.param("userId", "brown")
							.param("pass", "brownpass")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		String userId = (String) mav.getModel().get("userId");
		String pass = (String) mav.getModel().get("pass");

		/***Then***/
		assertEquals("hello", viewName);
		assertEquals("brown_attr", userId);
		assertEquals("brownpass_attr", pass);
			
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void modelAndViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/modelAndView")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		List<String> rangers = (List<String>) mav.getModel().get("rangers");

		/***Then***/
		assertEquals(3, rangers.size());
	}
	
	@Test
	public void voTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/vo")
				.param("userId", "brown")
				.param("pass", "brownpass")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		UserVo userVo = (UserVo) mav.getModel().get("userVo");

		/***Then***/
		assertEquals("brown", userVo.getUserId());
	}

	
}


































