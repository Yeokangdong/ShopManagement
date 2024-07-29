package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.OrderCompleteVO;
import kr.co.shop.vo.OrderVO;

@Mapper("orderCompleteMapper")
public interface OrderCompleteMapper {

	/**
	 * 주문 order_no 최종데이터
	 * @param orderCompleteVO - 조회할 정보가 담긴 VO
	 * @return 업체 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getOrderCompleteNo(OrderCompleteVO orderCompleteVO) throws Exception;
	
	/**
	 * 주문 등록
	 * @param orderCompleteVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	void setOrderCompleteReg(OrderCompleteVO orderCompleteVO) throws Exception;
	
	/**
	 * 주문 삭제
	 * @param orderCompleteVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	void setOrderCompleteDelete(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 총갯수
	 * @param orderCompleteVO - 조회할 정보가 담긴 VO
	 * @return 주문 총갯수
	 * @exception Exception
	 */
	List<?> getOrderCompleteTotalCnt() throws Exception;
	
	/**
	 * 주문 목록
	 * @param orderCompleteVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	List<?> getOrderCompleteList(Map<String, Object> paramMap) throws Exception;
}