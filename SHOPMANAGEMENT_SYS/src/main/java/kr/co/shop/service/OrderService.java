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

import kr.co.shop.vo.OrderVO;

public interface OrderService {

	/**
	 * 주문 order_no 최종데이터
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getOrderNo(OrderVO orderVO) throws Exception;
	
	/**
	 * 주문 등록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	void setOrderReg(OrderVO orderVO) throws Exception;
	
	/**
	 * 주문 취소
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 취소
	 * @exception Exception
	 */
	void setOrderCancel(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 삭제
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	void setOrderDelete(Map<String, Object> paramMap) throws Exception;

	/**
	 * 주문 전체 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 총갯수
	 * @exception Exception
	 */
	List<?> getOrderTotalList() throws Exception;

	/**
	 * 주문 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	List<?> getOrderList(Map<String, Object> paramMap) throws Exception;
}