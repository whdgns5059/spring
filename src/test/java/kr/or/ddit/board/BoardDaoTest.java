package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.test.ServiceDaoConfigTest;

public class BoardDaoTest extends ServiceDaoConfigTest{

	
	@Resource(name="boardDao")
	private BoardDao boardDao;
	
	@Test
	public void test() {
		
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardDao.selectBoardList();
		
		/***Then***/
		assertEquals(3, boardList.size());
		
	}

}
