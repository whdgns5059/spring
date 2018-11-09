package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.user.model.PageVo;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProdDaoTest extends ServiceDaoConfigTest {

	@Resource(name="prodDao")
	private ProdDao prodDao;
	
	@Test
	public void selectProdListTest() {
		
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		/***When***/
		List<ProdVo> prodList = prodDao.selectProdList(pageVo);

		/***Then***/
		assertEquals(10, prodList.size());
		
		
	}
	
	@Test
	public void selectProdDetailTest() {
		/***Given***/
		String prodId = "P101000001";
		/***When***/
		ProdVo prod = prodDao.selectProdDetail(prodId);

		/***Then***/
		assertEquals("모니터 삼성전자15인치칼라", prod.getProd_name());
	}
	
	@Test
	public void getProdCountTest() {
		/***Given***/
		
		/***When***/
		int prodCnt = prodDao.getProdCount();

		/***Then***/
		assertEquals(74, prodCnt);
	}

}
