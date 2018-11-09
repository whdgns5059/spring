package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements UserDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	public List<UserVo> selectUserAll(){
		
		List<UserVo> result = template.selectList("user.selectUserAll");
		return result;
	}
	
	
	public UserVo selectUser(String userId){
		
		UserVo result = template.selectOne("user.selectUser", userId);
		return result; 
		
	}
	
	public UserVo selectUser(UserVo userVo){
		UserVo result = template.selectOne("user.selectUserByVo", userVo);
		return result;
	}


	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		List<UserVo> result = template.selectList("user.selectUserPageList", pageVo);
		return result;
	}

	/**
	 * 
	* Method : getUserCnt
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 유저 건수 조회
	 */
	@Override
	public int getUserCnt() {
		int result = template.selectOne("user.getUserCnt");
		return result;
	}

	/**
	* Method : insertUser
	* 작성자 : pc17
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		int insertCnt = template.insert("user.insertUser", userVo);
		
		return insertCnt;
	}


	@Override
	public int deleteUser(String userId) {
		int deleteCnt = template.delete("user.deleteUser", userId);

		return deleteCnt;
	}


	@Override
	public int updateUser(UserVo userVo) {
		int updateCnt = template.update("user.updateUser", userVo);

		return updateCnt;
	}
	
	
	

}
