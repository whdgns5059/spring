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
//service, dao에 대한 테스트시엔 root-context.xml 만 필요하다
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml",
								  "classpath:kr/or/ddit/config/spring/datasource-context.xml",
								  "classpath:kr/or/ddit/config/spring/transaction-context.xml" })
public class ServiceDaoConfigTest {
	
	@Ignore
	@Test
	public void test(){
		assertTrue(true);
	}

}
