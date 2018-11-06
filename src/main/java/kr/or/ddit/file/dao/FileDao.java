package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

//SpringBean으로 등록 : @Repository(이름을 안붙이면 클래스에서 앞에만 소문자)
@Repository
public class FileDao implements FileDaoInf{
	
	SqlSessionFactory factory;
	
	public FileDao() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
	}

	/**
	* Method : insertFile
	* 작성자 : pc17
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 정보 저장
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession session = factory.openSession();
		
		//sql 호출
		int insertCnt = session.insert("file.insertFile", fileVo);
		
		//트랜잭션a commit session close(	);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	

}
