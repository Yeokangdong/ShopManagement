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
package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import kr.co.shop.service.ProductService;
import kr.co.shop.vo.OrderVO;
import kr.co.shop.vo.ProductVO;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("productService")
public class ProducterviceImpl extends EgovAbstractServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProducterviceImpl.class);

	@Resource(name="productMapper")
	private ProductMapper productMapper;

	/**
	 * 주문 product_no 최종데이터
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 주문 product_no 최종데이터
	 * @exception Exception
	 */
	@Override
	public List<?> getProductNo() throws Exception {
		return productMapper.getProductNo();
	}

	/**
	 * 최근 등록한 상품 목록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 제조업체 목록
	 * @exception Exception
	 */
	public List<?> getMakeCompanyList() throws Exception {
		return productMapper.getMakeCompanyList();
	}

	/**
	 * 제조업체 목록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 최근 등록한 상품 목록 
	 * @exception Exception
	 */
	public List<?> getLastProductList() throws Exception {
		return productMapper.getLastProductList();
	}
	
	/**
	 * 상품 등록
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 등록
	 * @exception Exception
	 */
	@Override
	public void setProductReg(ProductVO productVO) throws Exception {
		productMapper.setProductReg(productVO);
	}

	/**
	 * 상품 정보
	 * @param productVO - 조회할 정보가 담긴 VO
	 * @return 상품 정보 
	 * @exception Exception
	 */
	public List<?> getProductInfo(Map<String, Object> paramMap) throws Exception {
		return productMapper.getProductInfo(paramMap);
	}
}