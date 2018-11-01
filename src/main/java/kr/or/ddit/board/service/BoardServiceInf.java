package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {
	
	List<BoardVo> selectBoardList();
	
	public BoardDaoInf getBoardDao();

	public void setBoardDao(BoardDaoInf boardDao);
	
}
