package kr.or.ddit.prod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.user.model.PageVo;

public class ProdControllerTest extends ControllerTestConfig{
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;

	@Test
	public void prodListTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/prod/prodPageList")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***When***/
		int pageCount = (int) mav.getModel().get("pageCount");

		/***Then** * */
		assertEquals("prod/prodList", mav.getViewName());
		assertEquals(8, pageCount);
	}
	
	@Test
	public void prodDetailTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/prod/prodDetail?prodId=P101000001")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***When***/
		ProdVo prodVo = (ProdVo) mav.getModel().get("prodVo");

		/***Then***/
		assertEquals("prod/prodDetail", mav.getViewName());
		assertEquals("모니터 삼성전자15인치칼라", prodVo.getProd_name());
	}

}
