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
import kr.co.shop.service.OrderHisService;
import kr.co.shop.vo.OrderHisVO;

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

@Service("orderHisService")
public class OrderHisServiceImpl extends EgovAbstractServiceImpl implements OrderHisService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderHisServiceImpl.class);

	@Resource(name="orderHisMapper")
	private OrderHisMapper orderHisMapper;
	
	/**
	 * 주문 orderHis_no 최종데이터
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderHisNo(OrderHisVO orderHisVO) throws Exception {
		return orderHisMapper.getOrderHisNo(orderHisVO);
	}
	
	/**
	 * 주문 등록
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	@Override
	public void setOrderHisReg(OrderHisVO orderHisVO) throws Exception {
		orderHisMapper.setOrderHisReg(orderHisVO);
	}
	
	/**
	 * 주문 삭제
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	@Override
	public void setOrderHisDelete(Map<String, Object> paramMap) throws Exception {
		orderHisMapper.setOrderHisDelete(paramMap);
	}
	
	/**
	 * 주문 총갯수
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 총갯수
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderHisTotalCnt() throws Exception {
		return orderHisMapper.getOrderHisTotalCnt();
	}
	
	/**
	 * 주문 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderHisList(Map<String, Object> paramMap) throws Exception {
		return orderHisMapper.getOrderHisList(paramMap);
	}
	
	/**
	 * 운송장 번호 입력
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 운송장 번호 입력
	 * @exception Exception
	 */
	@Override
	public void setOrderSongjanoNoModify(Map<String, Object> paramMap) throws Exception {
		orderHisMapper.setOrderSongjanoNoModify(paramMap);
	}
}