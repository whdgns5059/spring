package kr.or.ddit.prod.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.user.model.PageVo;

@Controller
@RequestMapping("/prod")
public class ProdController {
	
	
	@Resource(name="prodService")
	private ProdService prodService;
	
	@RequestMapping("/prodPageList")
	public String prodPageList(PageVo pageVo, Model model) {
		
		List<ProdVo> prodList = prodService.selectProdList(pageVo);
		int pageCount = prodService.getProdCount();
		
		pageCount = (int) (Math.ceil(pageCount * 0.1));							
	
		model.addAttribute("prodList", prodList);
		model.addAttribute("pageCount", pageCount);
		
		
		return "prod/prodList";
	}
	
	@RequestMapping("/prodDetail")
	public String prodDetail(@RequestParam("prodId") String prodId, Model model) {
		
		ProdVo prodVo = prodService.selectProdDetail(prodId);
		
		model.addAttribute("prodVo", prodVo);
		
		return "prod/prodDetail";
	}
	

}
