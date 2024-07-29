package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import kr.co.shop.vo.EmailVO;

@Mapper("emailMapper")
public interface EmailMapper {
	
	/**
	 * 이메일 등록
	 * @param emailVO - 조회할 정보가 담긴 VO
	 * @return 이메일 등록
	 * @exception Exception
	 */
	void setEmailReg(EmailVO emailVO) throws Exception;
	
	/**
	 * 이메일 정보
	 * @param emailVO - 조회할 정보가 담긴 VO
	 * @return 업체명 목록
	 * @exception Exception
	 */
	List<?> getOrderEmailInfo() throws Exception;
}