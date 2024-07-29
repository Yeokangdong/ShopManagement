package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.OrderHisVO;
import kr.co.shop.vo.OrderVO;

@Mapper("orderHisMapper")
public interface OrderHisMapper {

	/**
	 * 주문 order_no 최종데이터
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 업체 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getOrderHisNo(OrderHisVO orderHisVO) throws Exception;
	
	/**
	 * 주문 등록
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	void setOrderHisReg(OrderHisVO orderHisVO) throws Exception;
	
	/**
	 * 주문 삭제
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	void setOrderHisDelete(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 총갯수
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 총갯수
	 * @exception Exception
	 */
	List<?> getOrderHisTotalCnt() throws Exception;
	
	/**
	 * 주문 목록
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	List<?> getOrderHisList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 운송장 번호 입력
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 운송장 번호 입력
	 * @exception Exception
	 */
	void setOrderSongjanoNoModify(Map<String, Object> paramMap) throws Exception;
}