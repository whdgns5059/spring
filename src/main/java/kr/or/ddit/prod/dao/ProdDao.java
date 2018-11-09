package kr.or.ddit.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;

@Repository
public class ProdDao implements ProdDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		
		List<ProdVo> prodList = template.selectList("prod.selectProdPageList", pageVo);
		return prodList;
	}

	
	@Override
	public ProdVo selectProdDetail(String prod_id) {
		ProdVo prod = template.selectOne("prod.selectProdDetail", prod_id);
		return prod;
	}


	@Override
	public int getProdCount() {
		int prodCount = template.selectOne("prod.getProdCount");
		
		return prodCount;
	}

}
