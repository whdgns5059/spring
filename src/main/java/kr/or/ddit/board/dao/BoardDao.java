package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public class BoardDao implements BoardDaoInf{

	@Override
	public List<BoardVo> selectBoardList() {
		//연습용 DB조회 가정 
		BoardVo boardVo = new BoardVo(1, "자유게시판", "brown");
		BoardVo boardVo2 = new BoardVo(1, "공지사항", "cony");
		BoardVo boardVo3 = new BoardVo(1, "FAQ", "sally");
		List<BoardVo> boardList = new ArrayList<>();
		
		boardList.add(boardVo);
		boardList.add(boardVo2);
		boardList.add(boardVo3);
		
		return boardList;
	}

}
