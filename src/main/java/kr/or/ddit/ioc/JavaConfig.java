package kr.or.ddit.ioc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@Configuration
public class JavaConfig {
	
	//boardDao spring bean 등록
	//xml의 <bean id=boardDao" class="kr.or.ddit.board.dao.BoardDao" />와 같음
	@Bean
	public BoardDaoInf getBoardDao() {
		return new BoardDao();
	}
	
	
	@Bean
	public BoardServiceInf getBoardService() {
		BoardServiceInf boardService = new BoardService();
		boardService.setBoardDao(getBoardDao());
		return boardService;
	}
	
}
