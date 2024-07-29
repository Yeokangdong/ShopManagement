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
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import kr.co.shop.service.CustomerDBService;
import kr.co.shop.service.OrderService;
import kr.co.shop.vo.CustomerDBVO;
import kr.co.shop.vo.OrderVO;

@Controller
public class OrderController {
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name = "customerDBService")
	private CustomerDBService customerDBService;
	
	private OrderVO orderVO;
	private CustomerDBVO customerDBVO;
	
	/**
	 * 주문 전체 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOrderTotalList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOrderTotalList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<OrderVO> returnList = (List<OrderVO>) orderService.getOrderTotalList();

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 주문 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOrderList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOrderList(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<OrderVO> returnList = (List<OrderVO>) orderService.getOrderList(paramMap);

			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
    }
	
	/**
	 * 주문 취소
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@RequestMapping(value = "/setOrderCancel.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setOrderCancel(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{

			orderService.setOrderCancel(paramMap);
			orderService.setOrderDelete(paramMap);
			
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
	@RequestMapping(value = "/setOrderDelete.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setOrderDelete(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		JSONObject obj = new JSONObject();
		
		try{
			orderService.setOrderDelete(paramMap);
			
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
	@RequestMapping(value = "/setOrderReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setOrderReg(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

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
            //시트 수 (첫번째에만 존재하므로 0을 준다)
            //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
            XSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();
            for(rowindex = 1; rowindex < rows; rowindex++){
                //행을읽는다
                XSSFRow row = sheet.getRow(rowindex);
                if(row != null){

                    orderVO = new OrderVO();
                    customerDBVO = new CustomerDBVO();

                    LocalDate now = LocalDate.now();
                    //주문
        			List<String> returnList1 = (List<String>) orderService.getOrderNo(orderVO);
        			
        			//고객
        			List<String> returnList2 = (List<String>) customerDBService.getCustomerDBNo(customerDBVO);
                	
        			String oldMonth = null;
        			String newMonth = null;
        			String order_no = null;
        			
        			//주문 no
        			if(returnList1.size() == 0) {
        				oldMonth = String.format("%02d", now.getMonthValue());
        				
        				order_no = now.getYear() + String.format("%02d", now.getMonthValue()) + now.getDayOfMonth() + "-00000";
        				
        				orderVO.setOrder_no(order_no);
                        customerDBVO.setOrder_no(order_no);
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
					
					orderVO.setOrder_no(order_no);
                    customerDBVO.setOrder_no(order_no);

        			//고객 no
        			if(returnList2.size() == 0) {
        				String customer_no = "1";
        				
        				customerDBVO.setCustomer_no(customer_no);
        			}else {
        				for(int i = 0; i < returnList2.size(); i++) {
        					int no = Integer.parseInt(returnList2.get(i).toString());
        					no = no + 1;
        					String customer_no = String.valueOf(no);

        	        		customerDBVO.setCustomer_no(customer_no);
        				}
        			}
                	
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
                            orderVO.setProduct_no(value);
                            customerDBVO.setProduct_no(value);
                        }else if(columnindex == 1) {
                            orderVO.setOption_no(value);
                        }else if(columnindex == 2) {
                            orderVO.setReceive_nm(value);
                            customerDBVO.setCustomer_nm(value);
                        }else if(columnindex == 3) {
                            orderVO.setReceive_tel(value);
                            customerDBVO.setTelephone(value);
                        }else if(columnindex == 4) {
                            orderVO.setReceive_tel_etc(value);
                        }else if(columnindex == 5) {
                            orderVO.setReceive_address(value);
                        }else if(columnindex == 6) {
                            orderVO.setSend_nm(value);
                        }else if(columnindex == 7) {
                            orderVO.setSend_tel(value);
                        }else if(columnindex == 8) {
                            orderVO.setSend_tel_etc(value);
                        }else if(columnindex == 9) {
                            orderVO.setSend_address(value);
                        }else if(columnindex == 10) {
                            orderVO.setProduct_title(value);
                        }else if(columnindex == 11) {
                            orderVO.setBox_cnt(value);
                        }else if(columnindex == 12) {
                        	if(value != null || value != "") {
                                orderVO.setMessage(value);
                        	}
                        }
                    }
        			
                    //주문
        			orderService.setOrderReg(orderVO);
        			
        			//고객
        			customerDBService.setCustomerDBReg(customerDBVO);
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
