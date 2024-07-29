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
import kr.co.shop.service.CompanyService;
import kr.co.shop.vo.CompanyVO;

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

@Service("companyService")
public class CompanyServiceImpl extends EgovAbstractServiceImpl implements CompanyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Resource(name="companyMapper")
	private CompanyMapper companyMapper;

	/**
	 * 업체 company_no 최종데이터
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 등록
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyNo(CompanyVO companyVO) throws Exception {
		return companyMapper.getCompanyNo(companyVO);
	}
	
	/**
	 * 업체 등록
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 등록
	 * @exception Exception
	 */
	@Override
	public void setCompanyReg(CompanyVO companyVO) throws Exception {
		companyMapper.setCompanyReg(companyVO);
	}
	
	/**
	 * 업체 수정
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 등록
	 * @exception Exception
	 */
	@Override
	public void setCompanyModify(CompanyVO companyVO) throws Exception {
		companyMapper.setCompanyModify(companyVO);
	}
	
	/**
	 * 업체 삭제
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 업체 삭제
	 * @exception Exception
	 */
	@Override
	public void setCompanyDelete(CompanyVO companyVO) throws Exception {
		companyMapper.setCompanyDelete(companyVO);
	}
	
	/**
	 * 업체명 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체명 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyNoList(Map<String, Object> paramMap) throws Exception {
		return companyMapper.getCompanyNoList(paramMap);
	}
	
	/**
	 * 업체 총갯수
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 총갯수
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyTotalCnt() throws Exception {
		return companyMapper.getCompanyTotalCnt();
	}
	
	/**
	 * 업체 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyList(Map<String, Object> paramMap) throws Exception {
		return companyMapper.getCompanyList(paramMap);
	}
	
	/**
	 * 업체 정보
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 정보
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyInfo(Map<String, Object> paramMap) throws Exception {
		return companyMapper.getCompanyInfo(paramMap);
	}
	
	/**
	 * 업체 파일 목록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 파일 목록
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyFileList(Map<String, Object> paramMap) throws Exception {
		return companyMapper.getCompanyFileList(paramMap);
	}
	
	/**
	 * 업체 파일 기본키 정보
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 파일 기본키 정보
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyFileNo(Map<String, Object> paramMap) throws Exception {
		return companyMapper.getCompanyFileNo(paramMap);
	}
	
	/**
	 * 업체 파일 등록
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 파일 등록
	 * @exception Exception
	 */
	@Override
	public void setCompanyFilesReg(Map<String, Object> paramMap) throws Exception {
		companyMapper.setCompanyFilesReg(paramMap);
	}
	
	/**
	 * 업체 엑셀 다운로드
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 업체 엑셀 다운로드
	 * @exception Exception
	 */
	@Override
	public List<?> getCompanyFileDownload() throws Exception {
		return companyMapper.getCompanyFileDownload();
	}
}
