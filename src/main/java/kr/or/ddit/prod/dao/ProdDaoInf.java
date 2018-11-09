package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.PageVo;

public interface ProdDaoInf {
	
	/**
	 * 
	* Method : selectProdList
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 상품 리스트 가져오기
	* 	prod_id, prod_name, lprod_nm, prod_insdate
	 */
	List<ProdVo> selectProdList(PageVo pageVo);
	
	/**
	 * 
	* Method : selectProdDetail
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 상품 상세정보 가져오기
	* 	prod_id, prod_name, lprod_nm, buyer_name, buyer_mail.
	 */
	ProdVo selectProdDetail(String prod_id);
	

	/**
	 * 
	* Method : getProdCount
	* 작성자 : pc17
	* 변경이력 :
	* @return
	* Method 설명 : 상품 총 개수 가져오기
	 */
	int getProdCount();
	
}
