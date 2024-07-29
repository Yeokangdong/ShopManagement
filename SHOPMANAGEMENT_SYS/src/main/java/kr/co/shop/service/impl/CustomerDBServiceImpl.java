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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.shop.service.CompanyService;
import kr.co.shop.service.CustomerDBService;
import kr.co.shop.service.OrderService;
import kr.co.shop.service.LoginService;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.CustomerDBVO;
import kr.co.shop.vo.OrderVO;
import kr.co.shop.vo.LoginVO;

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

@Service("customerDBService")
public class CustomerDBServiceImpl extends EgovAbstractServiceImpl implements CustomerDBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDBServiceImpl.class);

	@Resource(name="customerDBMapper")
	private CustomerDBMapper customerDBMapper;
	
	/**
	 * 고객 order_no 최종데이터
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBNo(CustomerDBVO customerDBVO) throws Exception {
		return customerDBMapper.getCustomerDBNo(customerDBVO);
	}
	
	/**
	 * 고객 등록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 등록
	 * @exception Exception
	 */
	@Override
	public void setCustomerDBReg(CustomerDBVO customerDBVO) throws Exception {
		customerDBMapper.setCustomerDBReg(customerDBVO);
	}
	
	/**
	 * 고객 총원
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 총갯수
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBTotalCnt() throws Exception {
		return customerDBMapper.getCustomerDBTotalCnt();
	}
	
	/**
	 * 고객 목록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBList(Map<String, Object> paramMap) throws Exception {
		return customerDBMapper.getCustomerDBList(paramMap);
	}
	
	/**
	 * 고객 정보
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 정보
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBInfo(Map<String, Object> paramMap) throws Exception {
		return customerDBMapper.getCustomerDBInfo(paramMap);
	}
	
	/**
	 * 품목 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 품목 차트
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBProductChart() throws Exception {
		return customerDBMapper.getCustomerDBProductChart();
	}
	
	/**
	 * 등급 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 등급 차트
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBRankChart() throws Exception {
		return customerDBMapper.getCustomerDBRankChart();
	}
	
	/**
	 * 고객수 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객수 차트
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBCntChart() throws Exception {
		return customerDBMapper.getCustomerDBCntChart();
	}
}