package kr.co.shop.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("dashboardMapper")
public interface DashBoardMapper {
	
	/**
	 * 신규 주문
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 신규 주문
	 * @exception Exception
	 */
	List<?> getNewOrderCnt() throws Exception;
	
	/**
	 * 배송 준비
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 신규 주문
	 * @exception Exception
	 */
	List<?> getReadyDeliveryCnt() throws Exception;
	
	/**
	 * 배송중
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송중
	 * @exception Exception
	 */
	List<?> getDeliveryCnt() throws Exception;
	
	/**
	 * 배송중
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 배송중
	 * @exception Exception
	 */
	List<?> getDeliveryCompleteCnt() throws Exception;
	
	/**
	 * 취소
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 취소
	 * @exception Exception
	 */
	List<?> getOrderCancelCnt() throws Exception;
	
	/**
	 * 고객
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 고객
	 * @exception Exception
	 */
	List<?> getMakeCompanyCnt() throws Exception;
	
	/**
	 * 고객
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 고객
	 * @exception Exception
	 */
	List<?> getOutsourcingCompanyCnt() throws Exception;
	
	/**
	 * 고객
	 * @param dashboardVO - 조회할 정보가 담긴 VO
	 * @return 고객
	 * @exception Exception
	 */
	List<?> getCustomerDBCnt() throws Exception;
}