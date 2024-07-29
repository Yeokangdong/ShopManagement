package kr.co.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.EmployeeVO;

@Mapper("employeeMapper")
public interface EmployeeMapper {

	/**
	 * 직원 employee_no 최종데이터
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 직원 employee_no 최종데이터
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
	 * @return 직원 등록
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
	 * 직원 정보
	 * @param employeeVO - 조회할 정보가 담긴 VO
	 * @return 업체 정보
	 * @exception Exception
	 */
	List<?> getEmployeeInfo(Map<String, Object> paramMap) throws Exception;
}