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
import kr.co.shop.service.DashBoardService;
import kr.co.shop.service.LoginService;
import kr.co.shop.vo.CompanyVO;
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

@Service("dashboardService")
public class DashBoardServiceImpl extends EgovAbstractServiceImpl implements DashBoardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashBoardServiceImpl.class);

	@Resource(name="dashboardMapper")
	private DashBoardMapper dashboardMapper;
	
	/**
	 * 신규 주문
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 신규 주문
	 * @exception Exception
	 */
	@Override
	public List<?> getNewOrderCnt() throws Exception {
		return dashboardMapper.getNewOrderCnt();
	}
	
	/**
	 * 배송 준비
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송 준비
	 * @exception Exception
	 */
	@Override
	public List<?> getReadyDeliveryCnt() throws Exception {
		return dashboardMapper.getReadyDeliveryCnt();
	}
	
	/**
	 * 배송중
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송중
	 * @exception Exception
	 */
	@Override
	public List<?> getDeliveryCnt() throws Exception {
		return dashboardMapper.getDeliveryCnt();
	}
	
	/**
	 * 배송완료
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송완료
	 * @exception Exception
	 */
	@Override
	public List<?> getDeliveryCompleteCnt() throws Exception {
		return dashboardMapper.getDeliveryCompleteCnt();
	}
	
	/**
	 * 취소
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 취소
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderCancelCnt() throws Exception {
		return dashboardMapper.getOrderCancelCnt();
	}
	
	/**
	 * 제조
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 제조
	 * @exception Exception
	 */
	@Override
	public List<?> getMakeCompanyCnt() throws Exception {
		return dashboardMapper.getMakeCompanyCnt();
	}
	
	/**
	 * 외주
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 외주
	 * @exception Exception
	 */
	@Override
	public List<?> getOutsourcingCompanyCnt() throws Exception {
		return dashboardMapper.getOutsourcingCompanyCnt();
	}

	/**
	 * 고객
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 고객
	 * @exception Exception
	 */
	@Override
	public List<?> getCustomerDBCnt() throws Exception {
		return dashboardMapper.getCustomerDBCnt();
	}
}