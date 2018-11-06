package kr.or.ddit.test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
//컨트롤러 테스트를 위해선 service 스프링 빈을 주입받기 때문에
//service, dao에 대한 설정 파일도 필요하다
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml",
									"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
//스프링 컨테이너를 웹 기반에서 활용 가능한 WebApplicationContext 생성
@WebAppConfiguration
public class ControllerTestConfig {
	
	//webApplicationContext ==> MockMvc(dispatcherServlet)생성을 위해 필요
	
	@Autowired
	private WebApplicationContext context;
	
	protected MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Ignore
	@Test
	public void test(){
		assertTrue(true);
	}

}
