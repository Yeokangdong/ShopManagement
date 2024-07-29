package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import kr.co.shop.vo.CustomerDBVO;

@Mapper("customerDBMapper")
public interface CustomerDBMapper {

	/**
	 * 주문 company_no 최종데이터
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 업체 company_no 최종데이터
	 * @exception Exception
	 */
	List<?> getCustomerDBNo(CustomerDBVO customerDBVO) throws Exception;
	
	/**
	 * 고객 등록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 등록
	 * @exception Exception
	 */
	void setCustomerDBReg(CustomerDBVO customerDBVO) throws Exception;

	/**
	 * 고객 총원
	 * @param customerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 총원
	 * @exception Exception
	 */
	List<?> getCustomerDBTotalCnt() throws Exception;
	
	/**
	 * 고객 목록
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 목록
	 * @exception Exception
	 */
	List<?> getCustomerDBList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 고객 정보
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객 정보
	 * @exception Exception
	 */
	List<?> getCustomerDBInfo(Map<String, Object> paramMap) throws Exception;

	/**
	 * 품목 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 품목 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBProductChart() throws Exception;

	/**
	 * 등급 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 등급 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBRankChart() throws Exception;

	/**
	 * 고객수 차트
	 * @param CustomerDBVO - 조회할 정보가 담긴 VO
	 * @return 고객수 차트
	 * @exception Exception
	 */
	List<?> getCustomerDBCntChart() throws Exception;
}