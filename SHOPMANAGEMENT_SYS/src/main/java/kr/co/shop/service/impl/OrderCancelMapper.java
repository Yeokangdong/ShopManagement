package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import kr.co.shop.vo.OrderVO;

@Mapper("orderCancelMapper")
public interface OrderCancelMapper {
	
	/**
	 * 주문 취소 전체 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 전체 목록
	 * @exception Exception
	 */
	List<?> getOrderCancelTotalCnt() throws Exception;
	
	/**
	 * 주문 취소 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	List<?> getOrderCancelList(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 취소 삭제
	 * @param orderHisVO - 조회할 정보가 담긴 VO
	 * @return 주문 취소 삭제
	 * @exception Exception
	 */
	void setOrderCancelDelete(Map<String, Object> paramMap) throws Exception;
}