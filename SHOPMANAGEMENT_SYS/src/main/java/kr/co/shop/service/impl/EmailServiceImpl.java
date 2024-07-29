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

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.shop.service.EmailService;
import kr.co.shop.vo.EmailVO;

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

@Service("emailService")
public class EmailServiceImpl extends EgovAbstractServiceImpl implements EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Resource(name="emailMapper")
	private EmailMapper emailMapper;
	
	/**
	 * 이메일 등록
	 * @param EmailVO - 조회할 정보가 담긴 VO
	 * @return 이메일 등록
	 * @exception Exception
	 */
	@Override
	public void setEmailReg(EmailVO emailVO) throws Exception {
		emailMapper.setEmailReg(emailVO);
	}
	
	/**
	 * 이메일 정보
	 * @param companyVO - 조회할 정보가 담긴 VO
	 * @return 이메일 정보
	 * @exception Exception
	 */
	@Override
	public List<?> getOrderEmailInfo() throws Exception {
		return emailMapper.getOrderEmailInfo();
	}
}
