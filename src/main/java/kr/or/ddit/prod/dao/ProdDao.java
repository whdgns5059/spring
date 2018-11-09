package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;

@Repository
public class ProdDao implements ProdDaoInf{

	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		List<ProdVo> prodList = session.selectList("prod.selectProdPageList", pageVo);
		session.close();
		return prodList;
	}

	
	@Override
	public ProdVo selectProdDetail(String prod_id) {
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		ProdVo prod = session.selectOne("prod.selectProdDetail", prod_id);
		session.close();
		return prod;
	}


	@Override
	public int getProdCount() {
		SqlSessionFactory sqlFactory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		int prodCount = session.selectOne("prod.getProdCount");
		session.close();
		
		return prodCount;
	}

}
