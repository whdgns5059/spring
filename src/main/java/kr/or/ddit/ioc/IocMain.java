package kr.or.ddit.ioc;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {

	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	
	
	public static void main(String[] args) {
		
		//스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] {"classpath:kr/or/ddit/ioc/application-context.xml"
		});

		//스프링 컨테이너에서 boardDao 스프링 빈을 요청(DL: dependency Lookup)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVO : {}", boardVo);
		}
		
		//스프링 컨테이너에서 boardService 스프링 빈 요청
		//selectBoardList 결과를 logger로 요청
		BoardServiceInf boardService = (BoardServiceInf)context.getBean("boardService");
		List<BoardVo> boardListSer = boardService.selectBoardList();
		
		for(BoardVo boardVo : boardListSer) {
			logger.debug("boardVoSer : {}", boardVo);
		}
		
		//생성자를 이용한 BoardService요청
		BoardServiceInf boardServiceConst = (BoardServiceInf)context.getBean("boardServiceConst");
		List<BoardVo> boardListConst = boardService.selectBoardList();
		
		for(BoardVo boardVo : boardListConst) {
			logger.debug("boardVoSer : {}", boardVo);
		}
		
		
		//springScope protoType test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoProtoType1", BoardDaoInf.class);
		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoProtoType1", BoardDaoInf.class);
	
		logger.debug("spring prototype bead test : {}", boardDaoPrototype1 == boardDaoPrototype2);
		
		
		BoardDaoInf boardDaoSingleton1 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		BoardDaoInf boardDaoSingleton2 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		
		logger.debug("spring singleton bean test : {}", boardDaoSingleton1==boardDaoSingleton2);
		
		
	}
	
}
