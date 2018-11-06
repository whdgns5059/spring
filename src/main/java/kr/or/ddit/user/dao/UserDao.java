package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

@Repository
public class UserDao implements UserDaoInf{

	public List<UserVo> selectUserAll(){
		
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<UserVo> result = session.selectList("user.selectUserAll");
		session.close();
		return result;
	}
	
	
	public UserVo selectUser(String userId){
		
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		UserVo result = session.selectOne("user.selectUser", userId);
		session.close();
		return result; 
		
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		UserVo result = session.selectOne("user.selectUserByVo", userVo);
		session.close();
		return result;
	}


	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<UserVo> result = session.selectList("user.selectUserPageList", pageVo);
		session.close();
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
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int result = session.selectOne("user.getUserCnt");
		session.close();
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
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int insertCnt = session.insert("user.insertUser", userVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}


	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int deleteCnt = session.delete("user.deleteUser", userId);
		session.commit();
		session.close();

		return deleteCnt;
	}


	@Override
	public int updateUser(UserVo userVo) {
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int updateCnt = session.update("user.updateUser", userVo);
		session.commit();
		session.close();

		return updateCnt;
	}
	
	
	

}
