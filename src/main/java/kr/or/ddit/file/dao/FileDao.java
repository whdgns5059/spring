package kr.or.ddit.file.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.file.model.FileVo;

//SpringBean으로 등록 : @Repository(이름을 안붙이면 클래스에서 앞에만 소문자)
@Repository
public class FileDao implements FileDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
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
		
		//sql 호출
		int insertCnt = template.insert("file.insertFile", fileVo);
		
		
		return insertCnt;
	}
	
	

}
