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

public interface CompanyService {

	/**
	 * 업체 company_no 최종데이터
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 company_no 최종데이터
	 * @exception Exception
	 */
	List<?> getCompanyNo(CompanyVO companyVO) throws Exception;
	
	/**
	 * 업체 등록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 등록
	 * @exception Exception
	 */
	void setCompanyReg(CompanyVO companyVO) throws Exception;
	
	/**
	 * 업체 수정
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 수정
	 * @exception Exception
	 */
	void setCompanyModify(CompanyVO companyVO) throws Exception;
	
	/**
	 * 업체 삭제
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 삭제
	 * @exception Exception
	 */
	void setCompanyDelete(CompanyVO companyVO) throws Exception;

	/**
	 * 업체명 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 목록
	 * @exception Exception
	 */
	List<?> getCompanyNoList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 업체 총갯수
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 총갯수
	 * @exception Exception
	 */
	List<?> getCompanyTotalCnt() throws Exception;

	/**
	 * 업체 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 목록
	 * @exception Exception
	 */
	List<?> getCompanyList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 정보
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 정보
	 * @exception Exception
	 */
	List<?> getCompanyInfo(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 파일 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 파일 목록
	 * @exception Exception
	 */
	List<?> getCompanyFileList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 기본키 정보
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 기본키 정보
	 * @exception Exception
	 */
	List<?> getCompanyFileNo(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 파일 등록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 파일 등록
	 * @exception Exception
	 */
	void setCompanyFilesReg(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 업체 엑셀 다운로드
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 엑셀 다온로드
	 * @exception Exception
	 */
	List<?> getCompanyFileDownload() throws Exception;
}