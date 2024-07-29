package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("deliveryTrackingMapper")
public interface DeliveryTrackingMapper {

	/**
	 * 상품 추적 정보
	 * @param deliveryTrackingVO - 조회할 정보가 담긴 VO
	 * @return 상품 추적 정보
	 * @exception Exception
	 */
	List<?> getOrderHisInfo(Map<String, Object> paramMap) throws Exception;
}