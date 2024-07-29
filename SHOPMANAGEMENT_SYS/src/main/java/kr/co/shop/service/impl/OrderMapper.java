package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import kr.co.shop.vo.OrderVO;

@Mapper("orderMapper")
public interface OrderMapper {

	/**
	 * 주문 order_no 최종데이터
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 업체 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getOrderNo(OrderVO orderVO) throws Exception;
	
	/**
	 * 주문 등록
	 * @param OrderVO - 조회할 정보가 담긴 VO
	 * @return 주문 등록
	 * @exception Exception
	 */
	void setOrderReg(OrderVO orderVO) throws Exception;
	
	/**
	 * 주문 취소
	 * @param OrderVO - 조회할 정보가 담긴 VO
	 * @return 주문 취소
	 * @exception Exception
	 */
	void setOrderCancel(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 삭제
	 * @param OrderVO - 조회할 정보가 담긴 VO
	 * @return 주문 삭제
	 * @exception Exception
	 */
	void setOrderDelete(Map<String, Object> paramMap) throws Exception;
	
	/**
	 * 주문 전체 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 전체 목록
	 * @exception Exception
	 */
	List<?> getOrderTotalList() throws Exception;
	
	/**
	 * 주문 목록
	 * @param orderVO - 조회할 정보가 담긴 VO
	 * @return 주문 목록
	 * @exception Exception
	 */
	List<?> getOrderList(Map<String, Object> paramMap) throws Exception;
}