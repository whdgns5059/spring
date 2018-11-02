package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration
public class LoginViewTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/user/loginView")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login", mav.getViewName());
	}
	
	@Test
	public void loginProcessTest() throws Exception {
	
		/***Given***/
		//*
		String userId = "brown";
		String pass = "brownpass";
		/*/
		String userId = "wrong";
		String pass = "wrongpass";
		//*/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", userId).param("pass", pass)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
	
		String viewName = mav.getViewName();
		
		/***Then***/
		assertEquals("main", viewName);
		
	}
	
	@Test
	public void loginProcessTest2() throws Exception {
	
		/***Given***/
		/*
		String userId = "brown";
		String pass = "brownpass";
		/*/
		String userId = "wrong";
		String pass = "wrongpass";
		//*/
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", userId).param("pass", pass)).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
	
		String viewName = mav.getViewName();
		
		/***Then***/
		assertEquals("login", viewName);
		
	}

	
	

	
	
	
	
}



























