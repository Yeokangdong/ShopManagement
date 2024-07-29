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
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import kr.co.shop.util.Util;
import kr.co.shop.vo.CompanyVO;

@Controller
public class CompanyController {
	
	@Resource(name = "companyService")
	private CompanyService companyService;
	
	private CompanyVO companyVO;

	/**
	 * 업체명 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCompanyNoList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyNoList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<CompanyVO> returnList = (List<CompanyVO>) companyService.getCompanyNoList(paramMap);
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 업체 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCompanyList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{

			List<CompanyVO> returnTotalCnt = (List<CompanyVO>) companyService.getCompanyTotalCnt();
			List<CompanyVO> returnList = (List<CompanyVO>) companyService.getCompanyList(paramMap);

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
	 * 업체 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCompanyReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCompanyReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		String company_type = paramMap.get("company_type").toString();
		String company_nm = paramMap.get("company_nm").toString();
		String ceo_nm = paramMap.get("ceo_nm").toString();
		String business_tax = paramMap.get("business_tax").toString();
		String business_no = paramMap.get("business_no").toString();
		String telephone = paramMap.get("telephone").toString();
		String email = paramMap.get("email").toString();
		String address = paramMap.get("address").toString();
		String bank_nm = paramMap.get("bank_nm").toString();
		String bank_no = paramMap.get("bank_no").toString();
		String bank_account_holder = paramMap.get("bank_account_holder").toString();
		String bank_deposit = paramMap.get("bank_deposit").toString();

		companyVO = new CompanyVO();
		companyVO.setCompany_type(company_type);
		companyVO.setCompany_nm(company_nm);
		companyVO.setCeo_nm(ceo_nm);
		companyVO.setBusiness_tax(business_tax);
		companyVO.setBusiness_no(business_no);
		companyVO.setTelephone(telephone);
		companyVO.setEmail(email);
		companyVO.setAddress(address);
		companyVO.setBank_nm(bank_nm);
		companyVO.setBank_no(bank_no);
		companyVO.setBank_account_holder(bank_account_holder);
		companyVO.setBank_deposit(bank_deposit);
		
		JSONObject obj = new JSONObject();
		
		try{
			
			LocalDate now = LocalDate.now();
			List<String> returnList = (List<String>) companyService.getCompanyNo(companyVO);
			
			if(returnList.size() == 0) {
				String company_no = "CO-" + now.getYear() + "-0000";
				companyVO.setCompany_no(company_no);
			}else {
				for(int i = 0; i < returnList.size(); i++) {
					String company_no = returnList.get(i).toString();
					
					String strNo = company_no.substring(0, 3);
					int no = (Integer.parseInt(company_no.substring(8)));
					
					company_no = strNo + now.getYear() + "-" + String.format("%04d", (no + 1));
					
					companyVO.setCompany_no(company_no);
				}
			}
			
			companyService.setCompanyReg(companyVO);	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 업체 수정
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCompanyModify.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCompanyModify(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		String company_no = paramMap.get("company_no").toString();
		String company_type = paramMap.get("company_type").toString();
		String company_nm = paramMap.get("company_nm").toString();
		String ceo_nm = paramMap.get("ceo_nm").toString();
		String business_tax = paramMap.get("business_tax").toString();
		String business_no = paramMap.get("business_no").toString();
		String telephone = paramMap.get("telephone").toString();
		String email = paramMap.get("email").toString();
		String address = paramMap.get("address").toString();
		String bank_nm = paramMap.get("bank_nm").toString();
		String bank_no = paramMap.get("bank_no").toString();
		String bank_account_holder = paramMap.get("bank_account_holder").toString();
		String bank_deposit = paramMap.get("bank_deposit").toString();

		companyVO = new CompanyVO();
		companyVO.setCompany_no(company_no);
		companyVO.setCompany_type(company_type);
		companyVO.setCompany_nm(company_nm);
		companyVO.setCeo_nm(ceo_nm);
		companyVO.setBusiness_tax(business_tax);
		companyVO.setBusiness_no(business_no);
		companyVO.setTelephone(telephone);
		companyVO.setEmail(email);
		companyVO.setAddress(address);
		companyVO.setBank_nm(bank_nm);
		companyVO.setBank_no(bank_no);
		companyVO.setBank_account_holder(bank_account_holder);
		companyVO.setBank_deposit(bank_deposit);
		
		JSONObject obj = new JSONObject();
		
		try{
			
			companyService.setCompanyModify(companyVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 업체 삭제
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCompanyDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCompanyDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		companyVO = new CompanyVO();
		
		JSONObject obj = new JSONObject();
		
		try{
			
			companyVO.setCompany_no(paramMap.get("company_no").toString());
			
			companyService.setCompanyDelete(companyVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 업체 정보
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCompanyInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyInfo(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<CompanyVO> companyInfo = (List<CompanyVO>) companyService.getCompanyInfo(paramMap);
			
			obj.put("companyInfo", companyInfo);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 업체 파일 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCompanyFileList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyDocList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<CompanyVO> returnList = (List<CompanyVO>) companyService.getCompanyFileList(paramMap);
			
			obj.put("returnList", returnList);			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 업체 파일 다운로드
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCompanyFileDownload.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getCompanyFileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			List<CompanyVO> returnList = (List<CompanyVO>) companyService.getCompanyFileDownload();
			
			String uri = "D:\\Shop\\엑셀 양식\\업체.xlsx";
			
            FileInputStream file = new FileInputStream(uri);
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            if(returnList.size() == 0) {
				
			}else{
				XSSFSheet sheet = workbook.getSheetAt(0);
				
				int j = 1;
				for(int i = 0; i < returnList.size(); i++) {
					
					//과세
					String tax = returnList.get(i).getCompany_type();
					if(tax.equals("1")) {
						tax = "제조";
					}else if(tax.equals("2")) {
						tax = "외주";
					}
					
					//과세
					String type = returnList.get(i).getBusiness_tax();
					if(type.equals("1")) {
						type = "일반과세자";
					}else if(type.equals("2")) {
						type = "간이과세자";
					}else if(type.equals("2")) {
						type = "면세과세자";
					}
					
					XSSFRow row = sheet.createRow(j);
					row.createCell(0).setCellValue(returnList.get(i).getCompany_no());
					row.createCell(1).setCellValue(tax);
					row.createCell(2).setCellValue(returnList.get(i).getCompany_nm());
					row.createCell(3).setCellValue(returnList.get(i).getCeo_nm());
					row.createCell(4).setCellValue(type);
					row.createCell(5).setCellValue(returnList.get(i).getBusiness_no());
					row.createCell(6).setCellValue(returnList.get(i).getTelephone());
					row.createCell(7).setCellValue(returnList.get(i).getEmail());
					row.createCell(8).setCellValue(returnList.get(i).getAddress());
					row.createCell(9).setCellValue(returnList.get(i).getBank_nm());
					row.createCell(10).setCellValue(returnList.get(i).getBank_no());
					row.createCell(11).setCellValue(returnList.get(i).getBank_account_holder());
					row.createCell(12).setCellValue(returnList.get(i).getBank_deposit());
					row.createCell(13).setCellValue(returnList.get(i).getCreate_dt());
					
					j++;
				}
				// 출력 파일 위치및 파일명 설정		
				FileOutputStream outFile;		
				
				try {			
					outFile = new FileOutputStream("D:\\Shop\\다운로드\\업체 목록.xlsx");
					workbook.write(outFile);
					outFile.close();
				}catch (Exception e) {			
					e.printStackTrace();
				}
			}
			
            obj.put("url", "/다운로드/업체 목록.xlsx");
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 업체 파일 업로드
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setCompanyFilesReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setCompanyFilesReg(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		JSONObject obj = new JSONObject();
		
	    try{
	    	
			String[] companyNoArr = request.getParameterValues("company_no");
			String[] fileTypeArr = request.getParameterValues("file_type");
			
			String company_no = companyNoArr[0];
			String file_type = fileTypeArr[0];
	        
	        String url = "D:\\Shop\\업체\\" + company_no;
	        
	        File clsFolder = new File(url);
			if(!clsFolder.exists()){
				Util.addFolder(clsFolder, url);
			}
	        Iterator<String> files = request.getFileNames();
	        
	        while(files.hasNext()){
	            String uploadFile = files.next();
	                         
	            MultipartFile mFile = request.getFile(uploadFile);
	            File convFile = new File(mFile.getOriginalFilename());
	            
	            String fileNm = convFile.getName();
	            String fileExtention = fileNm.substring(fileNm.length() - 3, fileNm.length());
	            
	            try {
	            	HashMap<String, Object> hashMap = new HashMap<String, Object>();
	            	hashMap.put("company_no", company_no);
	            	
	            	List<String> returnList = (List<String>) companyService.getCompanyFileNo(hashMap);;
	    			
	    			if(returnList.size() == 0) {
	    				hashMap.put("file_no", "1");
	    			}else {
	    				for(int i = 0; i < returnList.size(); i++) {
	    					int file_no = Integer.parseInt(returnList.get(i).toString()) + 1;
	    					
	    					hashMap.put("file_no", file_no);
	    				}
	    			}
	    			
	            	hashMap.put("company_no", company_no);
	            	hashMap.put("file_type", file_type);
	            	hashMap.put("file_nm", fileNm);
	            	
	            	if(file_type.equals("1")) {
		            	hashMap.put("file_nm", "사업자등록증." + fileExtention);
	            		hashMap.put("file_path", url + new File("\\사업자등록증." + fileExtention));
	            		mFile.transferTo(new File(url + new File("\\사업자등록증." + fileExtention)));
	            	}else if(file_type.equals("2")) {
	            		hashMap.put("file_nm", "통장사본." + fileExtention);
	            		hashMap.put("file_path", url + new File("\\통장사본." + fileExtention));
	            		mFile.transferTo(new File(url + new File("\\통장사본." + fileExtention)));
	            	}else if(file_type.equals("3")) {
	            		hashMap.put("file_nm", "계약서." + fileExtention);
	            		hashMap.put("file_path", url + new File("\\계약서." + fileExtention));
	            		mFile.transferTo(new File(url + new File("\\계약서." + fileExtention)));
	            	}else {
	            		hashMap.put("file_nm", fileNm);
	            		hashMap.put("file_path", url + new File("\\" + fileNm));
	            		mFile.transferTo(new File(url + new File("\\" + fileNm)));
	            	}
	            	
	            	companyService.setCompanyFilesReg(hashMap);
	            	
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
}
