package kr.or.ddit.prod.serivce;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.test.ServiceDaoConfigTest;
import kr.or.ddit.user.model.PageVo;

public class ProdServiceTest extends ServiceDaoConfigTest{
	
	@Resource(name="prodService")
	private ProdService prodService;


	@Test
	public void selectProdListTest() {
		
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);
		/***When***/
		List<ProdVo> prodList = prodService.selectProdList(pageVo);

		/***Then***/
		assertEquals(10, prodList.size());
		
		
	}
	
	@Test
	public void selectProdDetailTest() {
		/***Given***/
		String prodId = "P101000001";
		/***When***/
		ProdVo prod = prodService.selectProdDetail(prodId);

		/***Then***/
		assertEquals("모니터 삼성전자15인치칼라", prod.getProd_name());
	}
	
	@Test
	public void getProdCountTest() {
		/***Given***/
		
		/***When***/
		int prodCnt = prodService.getProdCount();

		/***Then***/
		assertEquals(74, prodCnt);
	}
}
