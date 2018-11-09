package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.test.ServiceDaoConfigTest;

public class BoardServiceTest extends ServiceDaoConfigTest{

	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Test
	public void selectBoardListTest() {
		
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardService.selectBoardList();
		
		/***Then***/
		assertEquals(3, boardList.size());
		
	}

}
