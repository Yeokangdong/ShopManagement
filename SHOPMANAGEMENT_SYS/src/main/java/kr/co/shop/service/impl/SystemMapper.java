package kr.co.shop.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import kr.co.shop.vo.BusinessVO;
import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.CourierCompanyVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SystemVO;
import kr.co.shop.vo.LoginVO;

@Mapper("systemMapper")
public interface SystemMapper {
	
	/**
	 * 사용자 계정 수정
	 * @param loginVo - 조회할 정보가 담긴 VO
	 * @return 사용자 계정 수정
	 * @exception Exception
	 */
	void setUserModify(LoginVO loginVo) throws Exception;

	/**
	 * 사용자 계정 조회
	 * @param loginVo - 조회할 정보가 담긴 VO
	 * @return 사용자 계정
	 * @exception Exception
	 */
	List<?> getUserInfo(LoginVO loginVo) throws Exception;

	/**
	 * 로고 통계 조회
	 * @param userVo - 조회할 정보가 담긴 VO
	 * @return 사용자 계정
	 * @exception Exception
	 */
	List<?> getSettingStatisticsList() throws Exception;

	/**
	 * 로고 파일
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 로고 파일
	 * @exception Exception
	 */
	void setLogoFilesReg(Map<String, Object> map) throws Exception;
	
	/**
	 * 시스템 수정
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 시스템 수정
	 * @exception Exception
	 */
	void setSystemModify(SystemVO systemVO) throws Exception;

	/**
	 * 시스템 조회
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 시스템 조회
	 * @exception Exception
	 */
	List<?> getSystemInfo(SystemVO systemVO) throws Exception;

	/**
	 * 사업자 수정
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 사업자 수정
	 * @exception Exception
	 */
	void setBusinessModify(BusinessVO businessVO) throws Exception;

	/**
	 * 사업자 조회
	 * @param systemVO - 조회할 정보가 담긴 VO
	 * @return 시스템 조회
	 * @exception Exception
	 */
	List<?> getBusinessInfo() throws Exception;

	/**
	 * 카테고리 order_no 최종데이터
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 업체 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getCategoryNo() throws Exception;
	
	/**
	 * 카테고리 등록
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 등록
	 * @exception Exception
	 */
	void setCategoryReg(CategoryVO categoryVO) throws Exception;
	
	/**
	 * 카테고리 삭제
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 삭제
	 * @exception Exception
	 */
	void setCategoryDelete(CategoryVO categoryVO) throws Exception;
	
	/**
	 * 카테고리 목록
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 목록
	 * @exception Exception
	 */
	List<?> getCategoryList() throws Exception;
	
	/**
	 * 품목 item_no 최종데이터
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 업체 item_no 최종데이터
	 * @exception Exception
	 */
	List<?> getItemNo() throws Exception;
	
	/**
	 * 품목 등록
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 등록
	 * @exception Exception
	 */
	void setItemReg(ItemVO itemVO) throws Exception;
	
	/**
	 * 품목 삭제
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 삭제
	 * @exception Exception
	 */
	void setItemDelete(ItemVO itemVO) throws Exception;
	
	/**
	 * 품목 목록
	 * @param categoryVO - 조회할 정보가 담긴 VO
	 * @return 카테고리 목록
	 * @exception Exception
	 */
	List<?> getItemList(ItemVO itemVO) throws Exception;
	
	/**
	 * 판매 스토어 sellStore_no 최종데이터
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 업체 order_no 최종데이터
	 * @exception Exception
	 */
	List<?> getSellStoreNo() throws Exception;
	
	/**
	 * 판매 스토어 등록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 등록
	 * @exception Exception
	 */
	void setSellStoreReg(SellStoreVO sellStoreVO) throws Exception;
	
	/**
	 * 판매 스토어 수정
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 삭제
	 * @exception Exception
	 */
	void setSellStoreModify(SellStoreVO sellStoreVO) throws Exception;
	
	/**
	 * 판매 스토어 삭제
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 삭제
	 * @exception Exception
	 */
	void setSellStoreDelete(SellStoreVO sellStoreVO) throws Exception;
	
	/**
	 * 판매 스토어 목록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 판매 스토어 목록
	 * @exception Exception
	 */
	List<?> getSellStoreList() throws Exception;
	
	/**
	 * 택배사 수정
	 * @param courierCompanyVO - 조회할 정보가 담긴 VO
	 * @return 택배사 수정
	 * @exception Exception
	 */
	void setCourierCompanyModify(CourierCompanyVO courierCompanyVO) throws Exception;
	
	/**
	 * 택배사 목록
	 * @param sellStoreVO - 조회할 정보가 담긴 VO
	 * @return 택배사 목록
	 * @exception Exception
	 */
	List<?> getCourierCompanyList() throws Exception;
}