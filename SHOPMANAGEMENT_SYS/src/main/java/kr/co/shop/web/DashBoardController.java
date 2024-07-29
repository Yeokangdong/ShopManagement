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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.service.CompanyService;
import kr.co.shop.service.DashBoardService;
import kr.co.shop.util.Util;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.DashBoardVO;

@Controller
public class DashBoardController {
	
	@Resource(name = "dashboardService")
	private DashBoardService dashboardService;
	
	private DashBoardVO dashboardVO;
	
	/**
	 * 신규 주문
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getNewOrderCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getNewOrderCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getNewOrderCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 배송 준비
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getReadyDeliveryCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getReadyDeliveryCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getReadyDeliveryCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 배송중
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getDeliveryCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getDeliveryCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getDeliveryCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 배송완료
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getDeliveryCompleteCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getDeliveryCompleteCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getDeliveryCompleteCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 취소
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getOrderCancelCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOrderCancelCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getOrderCancelCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 고객
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getCustomerDBCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getCustomerDBCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 제조
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getMakeCompanyCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getMakeCompanyCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getMakeCompanyCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 외주
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/getOutsourcingCompanyCnt.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOutsourcingCompanyCnt(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<DashBoardVO> returnList = (List<DashBoardVO>) dashboardService.getOutsourcingCompanyCnt();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
}
