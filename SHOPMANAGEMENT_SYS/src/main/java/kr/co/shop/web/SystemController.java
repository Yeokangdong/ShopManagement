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

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.service.SystemService;
import kr.co.shop.util.Util;
import kr.co.shop.service.LoginService;
import kr.co.shop.vo.BusinessVO;
import kr.co.shop.vo.CategoryVO;
import kr.co.shop.vo.CourierCompanyVO;
import kr.co.shop.vo.ItemVO;
import kr.co.shop.vo.SellStoreVO;
import kr.co.shop.vo.SettingStatisticsVO;
import kr.co.shop.vo.SystemVO;
import kr.co.shop.vo.LoginVO;

@Controller
public class SystemController {
	
	@Resource(name = "systemService")
	private SystemService systemService;
	
	private LoginVO userVO;
	private SystemVO systemVO;
	private BusinessVO businessVO;
	private CategoryVO categoryVO;
	private ItemVO itemVO;
	private SellStoreVO sellStoreVO;
	private CourierCompanyVO courierCompanyVO;
	
	/**
	 * 사용자 계정 수정
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setUserModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setUserModify(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		userVO = new LoginVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			userVO.setUser_id(paramMap.get("user_id").toString());
			userVO.setUser_password(paramMap.get("user_password").toString());
			
			systemService.setUserModify(userVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 사용자 계정 조회
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getUserInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getUserInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		userVO = new LoginVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			userVO.setUser_id(session.getAttribute("user_id").toString());
			userVO.setUser_password(session.getAttribute("user_password").toString());
			
			List<LoginVO> userInfo = (List<LoginVO>) systemService.getUserInfo(userVO);
			
			obj.put("userInfo", userInfo);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 로고 통계 조회
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getStatisticsList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getStatisticsList(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			
			List<SettingStatisticsVO> returnList = (List<SettingStatisticsVO>) systemService.getSettingStatisticsList();
			
			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 로고 파일 업로드
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setLogoFilesReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setLogoFilesReg(HttpSession session, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject obj = new JSONObject();
		
	    try{
	    	
			String[] fileTypeArr = request.getParameterValues("file_type");
	        
	        String url = "D:\\Shop\\계정\\";
	        
	        Iterator<String> files = request.getFileNames();
	        
	        while(files.hasNext()){
	            String uploadFile = files.next();
	                         
	            MultipartFile mFile = request.getFile(uploadFile);
	            File convFile = new File(mFile.getOriginalFilename());
	            
	            String fileNm = convFile.getName();
	            
	            try {
	            	HashMap<String, Object> hashMap = new HashMap<String, Object>();
	            	hashMap.put("logo", fileNm);
	            	
	            	systemService.setLogoFilesReg(hashMap);
	            	
	            	mFile.transferTo(new File(url + new File(fileNm)));
	            	
	            	obj.put("message", "success");
	            } catch (Exception error) {
	            	obj.put("message", "fail");
	    			obj.put("error", error.getMessage().toString());
	            }
	        }
	    }catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 시스템 수정
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setSystemModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setSystemModify(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		systemVO = new SystemVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			systemVO.setLogo_img_change(paramMap.get("logo_img_change").toString());
			systemVO.setSystem_nm(paramMap.get("system_nm").toString());
			systemVO.setSystem_s_nm(paramMap.get("system_s_nm").toString());
			
			systemService.setSystemModify(systemVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 시스템 조회
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSystemInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getSystemInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		systemVO = new SystemVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			systemVO.setUser_id(session.getAttribute("user_id").toString());
			
			List<SystemVO> systemInfo = (List<SystemVO>) systemService.getSystemInfo(systemVO);
			
			obj.put("systemInfo", systemInfo);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 사업자 수정
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setBusinessModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setBusinessModify(@RequestParam Map<String, Object> paramMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		businessVO = new BusinessVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			businessVO.setBusiness_no(paramMap.get("business_no").toString());
			businessVO.setTele_sell(paramMap.get("tele_sell").toString());
			businessVO.setAddress(paramMap.get("address").toString());
			businessVO.setCustomer_center(paramMap.get("customer_center").toString());
			
			systemService.setBusinessModify(businessVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 사업자 조회
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBusinessInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getBusinessInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		systemVO = new SystemVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<BusinessVO> businessInfo = (List<BusinessVO>) systemService.getBusinessInfo();
			
			obj.put("businessInfo", businessInfo);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 카테고리 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCategoryReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCategoryReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		categoryVO = new CategoryVO();
		categoryVO.setCategory_nm(paramMap.get("category_nm").toString());
		
		JSONObject obj = new JSONObject();
		
		try{

			List<String> returnList = (List<String>) systemService.getCategoryNo();
			
			if(returnList.size() == 0) {
				String category_no = "001";
				categoryVO.setCategory_no(category_no);
			}else {
				for(int i = 0; i < returnList.size(); i++) {
					String category_no = returnList.get(i).toString();
					
					int categoryNo = Integer.parseInt(category_no) + 1;
					
					categoryVO.setCategory_no(String.format("%03d", categoryNo));
				}
			}
			
			systemService.setCategoryReg(categoryVO);	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 카테고리 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCategoryList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCategoryList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			List<CategoryVO> returnList = (List<CategoryVO>) systemService.getCategoryList();
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 카테고리 삭제
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCategoryDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCategoryDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		categoryVO = new CategoryVO();
		categoryVO.setCategory_no(paramMap.get("category_no").toString());
		
		JSONObject obj = new JSONObject();
		
		try{
			
			systemService.setCategoryDelete(categoryVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 폼목 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setItemReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setItemReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		itemVO = new ItemVO();
		itemVO.setItem_nm(paramMap.get("item_nm").toString());
		itemVO.setCategory_no(paramMap.get("category_no").toString());
		
		JSONObject obj = new JSONObject();
		
		try{

			List<String> returnList = (List<String>) systemService.getItemNo();
			
			if(returnList.size() == 0) {
				String Item_no = "001";
				itemVO.setItem_no(Item_no);
			}else {
				for(int i = 0; i < returnList.size(); i++) {
					String Item_no = returnList.get(i).toString();
					
					int ItemNo = Integer.parseInt(Item_no) + 1;
					
					itemVO.setItem_no(String.format("%03d", ItemNo));
				}
			}
			
			systemService.setItemReg(itemVO);	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 폼목 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getItemList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getItemList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		itemVO = new ItemVO();
		itemVO.setCategory_no(paramMap.get("category_no").toString());
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<ItemVO> returnList = (List<ItemVO>) systemService.getItemList(itemVO);
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 폼목 삭제
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setItemDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setItemDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		itemVO = new ItemVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			itemVO.setItem_no(paramMap.get("item_no").toString());
			
			systemService.setItemDelete(itemVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 판매 스토어 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setSellStoreReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setSellStoreReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		sellStoreVO = new SellStoreVO();
		sellStoreVO.setStore_nm(paramMap.get("store_nm").toString());
		
		JSONObject obj = new JSONObject();
		
		try{

			List<String> returnList = (List<String>) systemService.getSellStoreNo();
			
			if(returnList.size() == 0) {
				String store_no = "001";
				sellStoreVO.setStore_no(store_no);
			}else {
				for(int i = 0; i < returnList.size(); i++) {
					String store_no = returnList.get(i).toString();
					
					int storeNo = Integer.parseInt(store_no) + 1;
					
					sellStoreVO.setStore_no(String.format("%03d", storeNo));
				}
			}
			
			systemService.setSellStoreReg(sellStoreVO);	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 판매 스토어 수정
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setSellStoreChargeModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setSellStoreChargeModify(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		sellStoreVO = new SellStoreVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			sellStoreVO.setStore_no(paramMap.get("store_no").toString());
			sellStoreVO.setCharge(paramMap.get("charge").toString());
			
			systemService.setSellStoreModify(sellStoreVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 판매 스토어 삭제
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setSellStoreDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setSellStoreDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		sellStoreVO = new SellStoreVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			sellStoreVO.setStore_no(paramMap.get("store_no").toString());
			
			systemService.setSellStoreDelete(sellStoreVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 판매 스토어 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getSellStoreList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getSellStoreList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			List<SellStoreVO> returnList = (List<SellStoreVO>) systemService.getSellStoreList();
			
			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 택배사 수정
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCourierCompanyModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCourierCompanyModify(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		courierCompanyVO = new CourierCompanyVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			courierCompanyVO.setCourier_no(paramMap.get("courier_no").toString());
			courierCompanyVO.setFare(paramMap.get("charge").toString());
			
			systemService.setCourierCompanyModify(courierCompanyVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 택배사 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCourierCompanyList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCourierCompanyList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			List<SellStoreVO> returnList = (List<SellStoreVO>) systemService.getCourierCompanyList();
			
			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
}
