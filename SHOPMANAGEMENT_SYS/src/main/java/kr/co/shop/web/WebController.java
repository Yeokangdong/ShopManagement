/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.co.shop.web;

import java.util.List;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class WebController {
	
	/**
	 * 로그인 페이지로 이동한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/index.do", method=RequestMethod.GET)
	public String main() throws Exception {

		return "dist/pages/login/login";
	}
	
	/**
	 * 메인 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageDashboard.do", method=RequestMethod.GET)
	public String pageDashboard() throws Exception {

		String page = "dist/pages/dashboard/dashboard";
		
		return page;
	}
	
	/**
	 * 설정 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageSettings.do", method=RequestMethod.GET)
	public String pageSettings() throws Exception {

		String page = "dist/pages/settings/settings";
		
		return page;
	}
	
	/**
	 * 상품 조회 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageProduct.do", method=RequestMethod.GET)
	public String pageProduct() throws Exception {

		String page = "dist/pages/product/product";
		
		return page;
	}
	
	/**
	 * 상품 등록/수정 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageProductReg.do", method=RequestMethod.GET)
	public String pageProductReg() throws Exception {

		String page = "dist/pages/product/productReg";
		
		return page;
	}
	
	/**
	 * 상품 상세 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageProductDetail.do", method=RequestMethod.GET)
	public String pageProductDetail() throws Exception {

		String page = "dist/pages/product/productDetail";
		
		return page;
	}
	
	/**
	 * 업체 조회 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageCompany.do", method=RequestMethod.GET)
	public String pageCompany() throws Exception {

		String page = "dist/pages/company/company";
		
		return page;
	}
	
	/**
	 * 업체 등록 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageCompanyReg.do", method=RequestMethod.GET)
	public String pageCompanyReg() throws Exception {

		String page = "dist/pages/company/companyReg";
		
		return page;
	}

	/**
	 * 직원 등록 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageEmployeeReg.do", method=RequestMethod.GET)
	public String pageEmployeeReg() throws Exception {

		String page = "dist/pages/company/employeeReg";
		
		return page;
	}

	/**
	 * 다중 주문 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageOrder1Reg.do", method=RequestMethod.GET)
	public String pageOrder1Reg() throws Exception {

		String page = "dist/pages/order/order1Reg";
		
		return page;
	}

	/**
	 * 건별 주문 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageOrder2Reg.do", method=RequestMethod.GET)
	public String pageOrder2Reg() throws Exception {

		String page = "dist/pages/order/order2Reg";
		
		return page;
	}

	/**
	 * 주문 내역 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageOrderHis.do", method=RequestMethod.GET)
	public String pageOrderHis() throws Exception {

		String page = "dist/pages/orderHis/orderHis";
		
		return page;
	}
	
	/**
	 * 배송 완료 내역 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageOrderComplete.do", method=RequestMethod.GET)
	public String pageOrderCompleteInfo() throws Exception {

		String page = "dist/pages/orderComplete/orderComplete";
		
		return page;
	}
	
	/**
	 * 취소 내역 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageOrderCancel.do", method=RequestMethod.GET)
	public String pageOrderCancel() throws Exception {

		String page = "dist/pages/orderCancel/orderCancel";
		
		return page;
	}
	
	/**
	 * 상품 추적 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageDeliveryTracking.do", method=RequestMethod.GET)
	public String pageDeliveryTracking() throws Exception {

		String page = "dist/pages/deliveryTracking/deliveryTracking";
		
		return page;
	}
	
	/**
	 * 고객DB 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageCustomerDB.do", method=RequestMethod.GET)
	public String pageCustomerDB() throws Exception {

		String page = "dist/pages/customer/customerDB";
		
		return page;
	}
	
	/**
	 * 정산 내역 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageExactCalculation.do", method=RequestMethod.GET)
	public String pageExactCalculation() throws Exception {

		String page = "dist/pages/exactCalculation/exactCalculation";
		
		return page;
	}
	
	/**
	 * 카달로그 페이지로 이동 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/pageCadalog.do", method=RequestMethod.GET)
	public String pageCadalog() throws Exception {

		String page = "dist/pages/cadalog/cadalog";
		
		return page;
	}
}
