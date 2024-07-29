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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.EmployeeVO;

public interface EmployeeService {

	/**
	 * 직원 employee_no 최종데이터
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 직원 company_no 최종데이터
	 * @exception Exception
	 */
	List<?> getEmployeeNo() throws Exception;
	
	/**
	 * 직원 등록
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 등록
	 * @exception Exception
	 */
	void setEmployeeReg(EmployeeVO employeeVo) throws Exception;
	
	/**
	 * 직원 수정
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 수정
	 * @exception Exception
	 */
	void setEmployeeModify(EmployeeVO employeeVo) throws Exception;
	
	/**
	 * 직원 삭제
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 삭제
	 * @exception Exception
	 */
	void setEmployeeDelete(EmployeeVO employeeVo) throws Exception;

	/**
	 * 직원 목록
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 직원 목록
	 * @exception Exception
	 */
	List<?> getEmployeeList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 정보
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 업체 정보
	 * @exception Exception
	 */
	List<?> getEmployeeInfo(Map<String, Object> paramMap) throws Exception;

}