/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.shop.service;

import java.util.List;
import java.util.Map;

import kr.co.shop.vo.BusinessVO;
import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.CourierCompanyVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SystemVO;
import kr.co.shop.vo.LoginVO;
import kr.co.shop.vo.OrderVO;
import kr.co.shop.vo.ProductVO;

public interface ProductService {

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
	 * 제조업체 목록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 제조업체 목록 
	 * @exception Exception
	 */
	List<?> getMakeCompanyList() throws Exception;
	
	/**
	 * 상품 등록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 등록
	 * @exception Exception
	 */
	void setProductReg(ProductVO productVO) throws Exception;
	

	/**
	 * 상품 정보
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 정보
	 * @exception Exception
	 */
	List<?> getProductInfo(Map<String, Object> paramMap) throws Exception;
}
