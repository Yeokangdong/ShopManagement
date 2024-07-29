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

import java.util.Map;

import org.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.shop.service.CustomerDBService;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.CustomerDBVO;

@Controller
public class CustomDBController {
	
	@Resource(name = "customerDBService")
	private CustomerDBService customerDBService;
	
	private CustomerDBVO customerDBVO;
	
	/**
	 * 고객 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerDBList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{

			List<CustomerDBVO> returnTotalCnt = (List<CustomerDBVO>) customerDBService.getCustomerDBTotalCnt();
			List<CustomerDBVO> returnList = (List<CustomerDBVO>) customerDBService.getCustomerDBList(paramMap);

			obj.put("returnTotalCnt", returnTotalCnt);
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }

	/**
	 * 고객 정보
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerDBInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBInfo(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<CustomerDBVO> customerDBInfo = (List<CustomerDBVO>) customerDBService.getCustomerDBInfo(paramMap);
			
			obj.put("customerDBInfo", customerDBInfo);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }

	/**
	 * 품목 차트
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerDBProductChart.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBProductChart(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			
			List<CustomerDBVO> returnList = (List<CustomerDBVO>) customerDBService.getCustomerDBProductChart();
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }

	/**
	 * 등급 차트
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerDBRankChart.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBRankChart(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			
			List<CustomerDBVO> returnList = (List<CustomerDBVO>) customerDBService.getCustomerDBRankChart();
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }

	/**
	 * 고객수 차트
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerDBCntChart.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCustomerDBCntChart(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			
			List<CustomerDBVO> returnList = (List<CustomerDBVO>) customerDBService.getCustomerDBCntChart();
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
}
