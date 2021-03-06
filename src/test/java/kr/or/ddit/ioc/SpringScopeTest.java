package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.test.ServiceDaoConfigTest;

@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context.xml"})
public class SpringScopeTest extends ServiceDaoConfigTest{

	//DI(의존성 주입)
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardDaoSingleton")
	private BoardDaoInf boardDaoSingleton;

	@Test
	public void springBeanScopeSingletonTest() {
		
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotEquals(boardDao, boardDaoSingleton);
		
		
	}

}
