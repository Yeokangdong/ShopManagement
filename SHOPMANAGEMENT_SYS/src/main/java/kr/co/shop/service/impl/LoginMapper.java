package kr.co.shop.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SystemVO;
import kr.co.shop.vo.LoginVO;

@Mapper("loginMapper")
public interface LoginMapper {
	/**
	 * 사용자 계정 조회
	 * @param userVo - 조회할 정보가 담긴 VO
	 * @return 사용자 계정
	 * @exception Exception
	 */
	List<?> getUserInfo(LoginVO userVo) throws Exception;
}