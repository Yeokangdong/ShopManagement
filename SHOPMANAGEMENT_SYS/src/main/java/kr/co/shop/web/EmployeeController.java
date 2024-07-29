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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.shop.service.CompanyService;
import kr.co.shop.service.EmployeeService;
import kr.co.shop.util.Util;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.EmployeeVO;

@Controller
public class EmployeeController {
	
	@Resource(name = "employeeService")
	private EmployeeService employeeService;
	
	private EmployeeVO employeeVO;
	
	/**
	 * 직원 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setEmployeeReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setEmployeeReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		String company_no = paramMap.get("company_no").toString();
		String employee_nm = paramMap.get("employee_nm").toString();
		String charge = paramMap.get("charge").toString();
		String telephone = paramMap.get("telephone").toString();
		String email = paramMap.get("email").toString();

		employeeVO = new EmployeeVO();
		employeeVO.setCompany_no(company_no);
		employeeVO.setEmployee_nm(employee_nm);
		employeeVO.setCharge(charge);
		employeeVO.setTelephone(telephone);
		employeeVO.setEmail(email);
		
		JSONObject obj = new JSONObject();
		
		try{
			
			LocalDate now = LocalDate.now();
			List<String> returnList = (List<String>) employeeService.getEmployeeNo();
			
			if(returnList.size() == 0) {
				String employee_no = "1";
				employeeVO.setEmployee_no(employee_no);
			}else {
				for(int i = 0; i < returnList.size(); i++) {
					String employee_no = returnList.get(i).toString();
					
					int employeeNo = Integer.parseInt(employee_no) + 1;
					
					employeeVO.setEmployee_no(String.valueOf(employeeNo));
				}
			}
			
			employeeService.setEmployeeReg(employeeVO);	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 직원 수정
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setEmployeeModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setEmployeeModify(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		String employee_no = paramMap.get("employee_no").toString();
		String employee_nm = paramMap.get("employee_nm").toString();
		String charge = paramMap.get("charge").toString();
		String telephone = paramMap.get("telephone").toString();
		String email = paramMap.get("email").toString();

		employeeVO = new EmployeeVO();
		employeeVO.setEmployee_no(employee_no);
		employeeVO.setEmployee_nm(employee_nm);
		employeeVO.setCharge(charge);
		employeeVO.setTelephone(telephone);
		employeeVO.setEmail(email);
		
		JSONObject obj = new JSONObject();
		
		try{
			
			employeeService.setEmployeeModify(employeeVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 직원 삭제
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setEmployeeDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setEmployeeDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		employeeVO = new EmployeeVO();
		
		JSONObject obj = new JSONObject();
		
		try{

			employeeVO.setEmployee_no(paramMap.get("employee_no").toString());
			
			employeeService.setEmployeeDelete(employeeVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 직원 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployeeList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<EmployeeVO> returnList = (List<EmployeeVO>) employeeService.getEmployeeList(paramMap);
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 직원 정보
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployeeInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getEmployeeInfo(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<CompanyVO> employeeInfo = (List<CompanyVO>) employeeService.getEmployeeInfo(paramMap);
			
			obj.put("employeeInfo", employeeInfo);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
}
