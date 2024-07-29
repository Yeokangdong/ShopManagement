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

import kr.co.shop.service.EmployeeService;
import kr.co.shop.service.EmployeeService;
import kr.co.shop.service.LoginService;
import kr.co.shop.vo.EmployeeVO;
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

@Service("employeeService")
public class EmployeeServiceImpl extends EgovAbstractServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Resource(name="employeeMapper")
	private EmployeeMapper employeeMapper;

	/**
	 * 직원 Employee_no 최종데이터
	 * @param EmployeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 등록
	 * @exception Exception
	 */
	@Override
	public List<?> getEmployeeNo() throws Exception {
		return employeeMapper.getEmployeeNo();
	}
	
	/**
	 * 직원 등록
	 * @param EmployeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 등록
	 * @exception Exception
	 */
	@Override
	public void setEmployeeReg(EmployeeVO EmployeeVO) throws Exception {
		employeeMapper.setEmployeeReg(EmployeeVO);
	}
	
	/**
	 * 직원 수정
	 * @param EmployeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 등록
	 * @exception Exception
	 */
	@Override
	public void setEmployeeModify(EmployeeVO EmployeeVO) throws Exception {
		employeeMapper.setEmployeeModify(EmployeeVO);
	}
	
	/**
	 * 직원 삭제
	 * @param EmployeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 삭제
	 * @exception Exception
	 */
	@Override
	public void setEmployeeDelete(EmployeeVO employeeVo) throws Exception {
		employeeMapper.setEmployeeDelete(employeeVo);
	}
	
	/**
	 * 직원 목록
	 * @param companyRegVO - 조회할 정보가 담긴 VO
	 * @return 직원 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getEmployeeList(Map<String, Object> paramMap) throws Exception {
		return employeeMapper.getEmployeeList(paramMap);
	}
	
	/**
	 * 직원 정보
	 * @param companyRegVO - 조회할 정보가 담긴 VO
	 * @return 업체 정보
	 * @exception Exception
	 */
	@Override
	public List<?> getEmployeeInfo(Map<String, Object> paramMap) throws Exception {
		return employeeMapper.getEmployeeInfo(paramMap);
	}
}
