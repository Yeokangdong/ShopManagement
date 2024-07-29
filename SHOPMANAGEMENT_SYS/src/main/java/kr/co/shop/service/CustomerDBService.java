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

import kr.co.shop.vo.CustomerDBVO;
import kr.co.shop.vo.OrderVO;

public interface CustomerDBService {

	/**
	 * 고객 custom_no 최종데이터
	 * @param customDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 custom_no 최종데이터
	 * @exception Exception
	 */
	List<?> getCustomerDBNo(CustomerDBVO customerDBVO) throws Exception;
	
	/**
	 * 고객 등록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	void setCustomerDBReg(CustomerDBVO customerDBVO) throws Exception;

	/**
	 * 고객 총원
	 * @param customerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 총원
	 * @exception Exception
	 */
	List<?> getCustomerDBTotalCnt() throws Exception;
	
	/**
	 * 고객 목록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 목록
	 * @exception Exception
	 */
	List<?> getCustomerDBList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 고객 정보
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 정보
	 * @exception Exception
	 */
	List<?> getCustomerDBInfo(Map<String, Object> paramMap) throws Exception;

	/**
	 * 품목 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 품목 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBProductChart() throws Exception;

	/**
	 * 등급 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 등급 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBRankChart() throws Exception;

	/**
	 * 고객수 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객수 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBCntChart() throws Exception;
}