/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use tComplete file except in compliance with the License.
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
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
import kr.co.shop.service.CustomerDBService;
import kr.co.shop.service.OrderCompleteService;
import kr.co.shop.service.OrderService;
import kr.co.shop.util.Util;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.CustomerDBVO;
import kr.co.shop.vo.OrderCompleteVO;

@Controller
public class OrderCompleteController {
	
	@Resource(name = "orderCompleteService")
	private OrderCompleteService orderCompleteService;
	
	private OrderCompleteVO orderCompleteVO;
	
	/**
	 * 주문 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOrderCompleteList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOrderCompleteList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{

			List<OrderCompleteVO> returnTotalCnt = (List<OrderCompleteVO>) orderCompleteService.getOrderCompleteTotalCnt();
			List<OrderCompleteVO> returnList = (List<OrderCompleteVO>) orderCompleteService.getOrderCompleteList(paramMap);
			
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
	 * 주문 삭제
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setOrderCompleteDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setOrderCompleteDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			orderCompleteService.setOrderCompleteDelete(paramMap);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 주문 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setOrderCompleteReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setOrderCompleteReg(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try {
			String url = "D:\\Shop\\업로드\\";
			
	        Iterator<String> files = request.getFileNames();

	        String fileNm = null;
	        while(files.hasNext()){
	            String uploadFile = files.next();
	                         
	            MultipartFile mFile = request.getFile(uploadFile);
	            File convFile = new File(mFile.getOriginalFilename());
	            fileNm = convFile.getName();
	        	
	        	mFile.transferTo(new File(url + new File(fileNm)));
            }
	        
	        FileInputStream file = new FileInputStream(url + fileNm);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            int rowindex = 0;
            int columnindex = 0;
            int boxindex = 0;
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //행의 수
            int rows = sheet.getPhysicalNumberOfRows();
            for(rowindex = 1; rowindex < rows; rowindex++){
                //행을읽는다
                XSSFRow row = sheet.getRow(rowindex);
                if(row != null){

                    orderCompleteVO = new OrderCompleteVO();

                    LocalDate now = LocalDate.now();
                    //주문
        			List<String> returnList1 = (List<String>) orderCompleteService.getOrderCompleteNo(orderCompleteVO);
                	
        			String oldMonth = null;
        			String newMonth = null;
        			String order_no = null;
        			
        			//주문 no
        			if(returnList1.size() == 0) {
        				oldMonth = String.format("%02d", now.getMonthValue());
        				
        				order_no = now.getYear() + String.format("%02d", now.getMonthValue()) + now.getDayOfMonth() + "-00000";
        				
        				orderCompleteVO.setOrder_no(order_no);
        			}else {
        				for(int i = 0; i < returnList1.size(); i++) {
        					newMonth = String.format("%02d", now.getMonthValue());
        					
        					order_no = returnList1.get(i).toString();
        					
        					if(oldMonth != null && !oldMonth.equals(newMonth)) {
        						order_no = now.getYear() + String.format("%02d", now.getMonthValue()) + 
            							now.getDayOfMonth() + "-00000";
        					}else {
        						int no = (Integer.parseInt(order_no.substring(10)));
            					order_no = now.getYear() + String.format("%02d", now.getMonthValue()) + 
            							now.getDayOfMonth() + "-" + String.format("%05d", (no + 1));
        					}
        				}
        			}
        			
                    String product_no = null; 
                    String option_no = null;
                    String receive_nm = null; 
                    String receive_tel = null;
                    String receive_tel_etc = null;
                    String receive_address = null;
                    String send_nm = null;
                    String send_tel = null;
                    String send_tel_etc = null;
                    String send_address = null;
                    String product_title = null;
                    String box_cnt = null;
                    String message = null;
                    String songjang_no = null;
                	
                    //셀의 수
                    int cells = row.getPhysicalNumberOfCells();
                    for(columnindex = 0; columnindex <= cells; columnindex++) {
                        //셀값을 읽는다
                        XSSFCell cell = row.getCell(columnindex);
                        String value = "";
                        
                        if(cell == null){
                            continue;
                        }else{
                        	switch (cell.getCellType()){
	                            case XSSFCell.CELL_TYPE_FORMULA:
	                                value = cell.getCellFormula();
	                                break;
	                            case XSSFCell.CELL_TYPE_NUMERIC:
	                            	cell.setCellType(XSSFCell.CELL_TYPE_STRING);
	                            	value = cell.getStringCellValue();
	                                break;
	                            case XSSFCell.CELL_TYPE_STRING:
	                                value = cell.getStringCellValue();
	                                break;
	                            case XSSFCell.CELL_TYPE_BLANK:
	                                value = cell.getBooleanCellValue() + "";
	                                break;
	                            case XSSFCell.CELL_TYPE_ERROR:
	                                value = cell.getErrorCellValue() + "";
	                                break;
                            }
                        }
                        
                        if(value != null && value.equals("false")) {
                        	value = "";
                        }
                        
                        if(columnindex == 0) {
                        	product_no = value;
                        }else if(columnindex == 1) {
                        	option_no = value;
                        }else if(columnindex == 2) {
                        	receive_nm = value;
                        }else if(columnindex == 3) {
                        	receive_tel = value;
                        }else if(columnindex == 4) {
                        	receive_tel_etc = value;
                        }else if(columnindex == 5) {
                        	receive_address = value;
                        }else if(columnindex == 6) {
                        	send_nm = value;
                        }else if(columnindex == 7) {
                        	send_tel = value;
                        }else if(columnindex == 8) {
                        	send_tel_etc = value;
                        }else if(columnindex == 9) {
                        	send_address = value;
                        }else if(columnindex == 10) {
                        	product_title = value;
                        }else if(columnindex == 11) {
                        	box_cnt = value;
                        }else if(columnindex == 12) {
                        	if(value != null || value != "") {
                        		message = value;
                        	}
                        }
                    }
        			
                    int boxCnt = Integer.parseInt(box_cnt);
        			ArrayList<String> songjangList = Util.songjangArr(sheet, rowindex, boxCnt);
                    
                    for(boxindex = 1; boxindex <= boxCnt; boxindex++) {
            			if(boxindex >= 2) {
            				int no = (Integer.parseInt(order_no.substring(10)));
        					order_no = now.getYear() + String.format("%02d", now.getMonthValue()) + 
        							now.getDayOfMonth() + "-" + String.format("%05d", (no + 1));
            			}
            			
    					orderCompleteVO.setOrder_no(order_no);
            			orderCompleteVO.setProduct_no(product_no);
            			orderCompleteVO.setOption_no(option_no);
            			orderCompleteVO.setReceive_nm(receive_nm);
            			orderCompleteVO.setReceive_tel(receive_tel);
            			orderCompleteVO.setReceive_tel_etc(receive_tel_etc);
            			orderCompleteVO.setReceive_address(receive_address);
            			orderCompleteVO.setSend_nm(send_nm);
            			orderCompleteVO.setSend_tel(send_tel);
            			orderCompleteVO.setSend_tel_etc(send_tel_etc);
            			orderCompleteVO.setSend_address(send_address);
            			orderCompleteVO.setProduct_title(product_title);
            			orderCompleteVO.setBox_cnt("1");
            			orderCompleteVO.setMessage(message);
            			
            			if(songjangList.size() == 0) {
            				orderCompleteVO.setSongjang_no("");	
            			}else {
            				orderCompleteVO.setSongjang_no(songjangList.get((boxindex - 1)).toString());
            			}
            			
            			orderCompleteVO.setStatus("발송대기");
            			
                        //주문
            			orderCompleteService.setOrderCompleteReg(orderCompleteVO);
                    }
                }
            }	
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
}
