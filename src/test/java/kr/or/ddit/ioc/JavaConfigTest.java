package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.test.ServiceDaoConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JavaConfig.class})
public class JavaConfigTest {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Test
	public void boardDaoTest() {
		
		/***Given***/
		
		/***When***/
		
		/***Then***/
		
		assertNotNull(boardDao);
		assertNotNull(boardService);
	}

}
