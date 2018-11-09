package kr.or.ddit.prod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;

@Service
public class ProdService implements ProdServiceInf {
	
	ProdDaoInf prodDao = new ProdDao();
	
	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		return prodDao.selectProdList(pageVo);
	}

	@Override
	public ProdVo selectProdDetail(String prod_id) {
		return prodDao.selectProdDetail(prod_id);
	}

	@Override
	public int getProdCount() {
		return prodDao.getProdCount();
	}
		
	
	
}
