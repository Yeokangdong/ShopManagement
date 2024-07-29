package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.BusinessVO;
import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.CourierCompanyVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SystemVO;
import kr.co.shop.vo.LoginVO;
import kr.co.shop.vo.ProductVO;

@Mapper("productMapper")
public interface ProductMapper {

	/**
	 * 상품 product_no 최종데이터
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 product_no 최종데이터
	 * @exception Exception
	 */
	List<?> getProductNo() throws Exception;

	/**
	 * 최근 등록한 상품 목록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 최근 등록한 상품 목록 
	 * @exception Exception
	 */
	List<?> getLastProductList() throws Exception;
	
	/**
	 * 상품 등록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 등록
	 * @exception Exception
	 */
	void setProductReg(ProductVO productVO) throws Exception;
}