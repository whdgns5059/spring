package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-scan.xml"})
public class ComponentScanTest {

	private Logger logger = LoggerFactory.getLogger(ComponentScanTest.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	
	/**
	* Method : componentScanTest
	* 작성자 : pc17
	* 변경이력 :
	* Method 설명 : spring annotaion scan을 통해 스프링 빈이 
	* 				정상적으로 생성 되었는지 테스트
	*/
	@Test
	public void componentScanTest() {
		
		/***Given***/
		
		
		/***When***/
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo str : boardList) {
			logger.debug("str : {}", str);
		}
		
		
		
		/***Then***/
		assertNotNull(boardDao);
	}

	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Test
	public void componentScanServiceTest() {
		/***Given***/
		
		/***When***/
		List<BoardVo> boardListSer = boardService.selectBoardList();
		for(BoardVo str : boardListSer) {
			logger.debug("str : {}", str);
		}

		/***Then***/
	}

	
	@Test
	public void daoServiceDaoisEqualTest() {
		
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(boardDao, boardService.getBoardDao());
	}
	
}
