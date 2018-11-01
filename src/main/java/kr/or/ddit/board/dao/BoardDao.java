package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.board.model.BoardVo;

//이름을 생략하면 클래스 첫 글자를 소문자로 한 이름이 spring bean 이름이 됨
@Repository("boardDao")
public class BoardDao implements BoardDaoInf{

	/**
	* Method : selectBoardList
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 보드 셀렉트
	* 
	*/
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
