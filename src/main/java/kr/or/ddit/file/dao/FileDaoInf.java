package kr.or.ddit.file.dao;

import kr.or.ddit.file.model.FileVo;

public interface FileDaoInf {
	
	/**
	* Method : insertFile
	* 작성자 : pc17
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일정보 저장
	*/
	int insertFile(FileVo fileVo);
	
}
