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
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.shop.service.SystemService;
import kr.co.shop.service.LoginService;
import kr.co.shop.vo.BusinessVO;
import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.CourierCompanyVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SystemVO;
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

@Service("systemService")
public class SystemServiceImpl extends EgovAbstractServiceImpl implements SystemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemServiceImpl.class);

	@Resource(name="systemMapper")
	private SystemMapper systemMapper;
	
	/**
	 * 사용자 계정 수정
	 * @param loginVo - 조회할 정보가 담긴 VO
	 * @return 사용자 계정 수정
	 * @exception Exception
	 */
	@Override
	public void setUserModify(LoginVO userVO) throws Exception {
		systemMapper.setUserModify(userVO);
	}
	
	/**
	 * 계정 조회
	 * @param loginVo - 조회할 정보가 담긴 VO
	 * @return 계정 조회
	 * @exception Exception
	 */
	@Override
	public List<?> getUserInfo(LoginVO userVo) throws Exception {
		return systemMapper.getUserInfo(userVo);
	}
	
	/**
	 * 로고 통계 조회
	 * @param userVO - 조회할 정보가 담긴 VO
	 * @return 계정 조회
	 * @exception Exception
	 */
	@Override
	public List<?> getSettingStatisticsList() throws Exception {
		return systemMapper.getSettingStatisticsList();
	}
	
	/**
	 * 로고 파일
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 로고 파일
	 * @exception Exception
	 */
	@Override
	public void setLogoFilesReg(Map<String, Object> map) throws Exception {
		systemMapper.setLogoFilesReg(map);
	}
	
	/**
	 * 시스템 수정
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 시스템 수정
	 * @exception Exception
	 */
	@Override
	public void setSystemModify(SystemVO systemVO) throws Exception {
		systemMapper.setSystemModify(systemVO);
	}

	/**
	 * 시스템 조회
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 시스템 조회
	 * @exception Exception
	 */
	@Override
	public List<?> getSystemInfo(SystemVO systemVO) throws Exception {
		return systemMapper.getSystemInfo(systemVO);
	}
	
	/**
	 * 사업자 수정
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 사업자 수정
	 * @exception Exception
	 */
	@Override
	public void setBusinessModify(BusinessVO businessVO) throws Exception {
		systemMapper.setBusinessModify(businessVO);
	}

	/**
	 * 사업자 조회
	 * @param 사업자 - 조회할 정보가 담긴 VO
	 * @return 시스템 조회
	 * @exception Exception
	 */
	@Override
	public List<?> getBusinessInfo() throws Exception {
		return systemMapper.getBusinessInfo();
	}
	
	/**
	 * 주문 category_no 최종데이터
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 주문
	 * @exception Exception
	 */
	@Override
	public List<?> getCategoryNo() throws Exception {
		return systemMapper.getCategoryNo();
	}
	
	/**
	 * 주문 등록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	@Override
	public void setCategoryReg(CategoryVO categoryVO) throws Exception {
		systemMapper.setCategoryReg(categoryVO);
	}
	
	/**
	 * 주문 삭제
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	@Override
	public void setCategoryDelete(CategoryVO categoryVO) throws Exception {
		systemMapper.setCategoryDelete(categoryVO);
	}
	
	/**
	 * 주문 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCategoryList() throws Exception {
		return systemMapper.getCategoryList();
	}
	
	/**
	 * 주문 category_no 최종데이터
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 주문
	 * @exception Exception
	 */
	@Override
	public List<?> getItemNo() throws Exception {
		return systemMapper.getItemNo();
	}
	
	/**
	 * 주문 등록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	@Override
	public void setItemReg(ItemVO itemVO) throws Exception {
		systemMapper.setItemReg(itemVO);
	}
	
	/**
	 * 주문 삭제
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	@Override
	public void setItemDelete(ItemVO itemVO) throws Exception {
		systemMapper.setItemDelete(itemVO);
	}
	
	/**
	 * 주문 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getItemList(ItemVO itemVO) throws Exception {
		return systemMapper.getItemList(itemVO);
	}
	
	/**
	 * 판매 스토어 sellStore_no 최종데이터
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어
	 * @exception Exception
	 */
	@Override
	public List<?> getSellStoreNo() throws Exception {
		return systemMapper.getSellStoreNo();
	}
	
	/**
	 * 판매 스토어 등록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 등록
	 * @exception Exception
	 */
	@Override
	public void setSellStoreReg(SellStoreVO sellStoreVO) throws Exception {
		systemMapper.setSellStoreReg(sellStoreVO);
	}
	
	/**
	 * 판매 스토어 수정
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 삭제
	 * @exception Exception
	 */
	@Override
	public void setSellStoreModify(SellStoreVO sellStoreVO) throws Exception {
		systemMapper.setSellStoreModify(sellStoreVO);
	}
	
	/**
	 * 판매 스토어 삭제
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 삭제
	 * @exception Exception
	 */
	@Override
	public void setSellStoreDelete(SellStoreVO sellStoreVO) throws Exception {
		systemMapper.setSellStoreDelete(sellStoreVO);
	}
	
	/**
	 * 판매 스토어 목록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getSellStoreList() throws Exception {
		return systemMapper.getSellStoreList();
	}
	
	/**
	 * 판매 스토어 수정
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 삭제
	 * @exception Exception
	 */
	@Override
	public void setCourierCompanyModify(CourierCompanyVO courierCompanyVO) throws Exception {
		systemMapper.setCourierCompanyModify(courierCompanyVO);
	}
	
	/**
	 * 택배사 목록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 택배사 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCourierCompanyList() throws Exception {
		return systemMapper.getCourierCompanyList();
	}
}
