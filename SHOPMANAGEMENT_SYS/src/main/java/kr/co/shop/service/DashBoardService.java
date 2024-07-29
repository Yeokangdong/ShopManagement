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

public interface DashBoardService {

	/**
	 * 신규 주문
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 신규 주문
	 * @exception Exception
	 */
	List<?> getNewOrderCnt() throws Exception;

	/**
	 * 배송 준비
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송 준비
	 * @exception Exception
	 */
	List<?> getReadyDeliveryCnt() throws Exception;

	/**
	 * 배송중
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송중
	 * @exception Exception
	 */
	List<?> getDeliveryCnt() throws Exception;

	/**
	 * 배송완료
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송완료
	 * @exception Exception
	 */
	List<?> getDeliveryCompleteCnt() throws Exception;

	/**
	 * 취소
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 취소
	 * @exception Exception
	 */
	List<?> getOrderCancelCnt() throws Exception;

	/**
	 * 제조
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 제조
	 * @exception Exception
	 */
	List<?> getMakeCompanyCnt() throws Exception;

	/**
	 * 외주
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 외주
	 * @exception Exception
	 */
	List<?> getOutsourcingCompanyCnt() throws Exception;

	/**
	 * 취소
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송완료
	 * @exception Exception
	 */
	List<?> getCustomerDBCnt() throws Exception;
}