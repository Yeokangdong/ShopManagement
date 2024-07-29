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
import kr.co.shop.service.OrderService;
import kr.co.shop.vo.OrderVO;

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

@Service("orderService")
public class OrderServiceImpl extends EgovAbstractServiceImpl implements OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Resource(name="orderMapper")
	private OrderMapper orderMapper;
	
	/**
	 * 주문 order_no 최종데이터
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderNo(OrderVO orderVO) throws Exception {
		return orderMapper.getOrderNo(orderVO);
	}
	
	/**
	 * 주문 등록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	@Override
	public void setOrderReg(OrderVO orderVO) throws Exception {
		orderMapper.setOrderReg(orderVO);
	}
	
	/**
	 * 주문 취소
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	@Override
	public void setOrderCancel(Map<String, Object> paramMap) throws Exception {
		orderMapper.setOrderCancel(paramMap);
	}
	
	/**
	 * 주문 삭제
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	@Override
	public void setOrderDelete(Map<String, Object> paramMap) throws Exception {
		orderMapper.setOrderDelete(paramMap);
	}
	
	/**
	 * 주문 전체 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 전체 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderTotalList() throws Exception {
		return orderMapper.getOrderTotalList();
	}
	
	/**
	 * 주문 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderList(Map<String, Object> paramMap) throws Exception {
		return orderMapper.getOrderList(paramMap);
	}
}