package kr.or.ddit.rangers.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.rangers.model.RangerVo;

@Repository
public class RangersDao implements RangersDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : selectAllRangers
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : rangers전체정보조회
	*/
	public List<RangerVo> selectAllRangers() {
		
		List<RangerVo> rangers = template.selectList("rangers.selectAllRangers");
		
		return rangers;
	}

	@Override
	public int insertRanger(RangerVo ranger) {
		
		int insertCnt = template.insert("rangers.insertRanger", ranger);
		
		return insertCnt;
	}

}
