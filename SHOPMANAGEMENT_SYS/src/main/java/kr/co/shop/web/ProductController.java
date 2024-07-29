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

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.shop.service.ProductService;
import kr.co.shop.vo.ProductVO;

@Controller
public class ProductController {
	
	@Resource(name = "productService")
	private ProductService productService;
	
	private ProductVO productVO;
	
	/**
	 * 최근 등록한 상품 목록
	 * @param model
	 * @return 
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getLastProductList.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getLastProductList(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject obj = new JSONObject();
		
		try{
			
			List<ProductVO> returnList = (List<ProductVO>) productService.getLastProductList();
			
			obj.put("returnList", returnList);
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
	@RequestMapping(value = "/setProductReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setProductReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, HttpServletResponse response) throws Exception {

		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }
		
		productVO = new ProductVO();
		productVO.setCategory_no(paramMap.get("category_no").toString());
		productVO.setItem_no(paramMap.get("item_no").toString());
		productVO.setTax(paramMap.get("tax").toString());
		productVO.setBrand_title(paramMap.get("brand_title").toString());
		
		JSONObject obj = new JSONObject();
		
		try{
			
            LocalDate now = LocalDate.now();
			List<String> returnList = (List<String>) productService.getProductNo();
			
			if(returnList.size() == 0) {
				int now_year = now.getYear();
				String year = String.valueOf(now_year);
				year = year.substring(2);
				
				String product_no = productVO.getCategory_no() + productVO.getItem_no() + "-" + year + String.format("%02d", now.getMonthValue()) + "-P-" + "00001";
				
				productVO.setProduct_no(product_no);
			}else {
    			
				String oldMonth = null;
    			String newMonth = null;
    			String product_no = null;
    			
				for(int i = 0; i < returnList.size(); i++) {
					int now_year = now.getYear();
					String year = String.valueOf(now_year);
					year = year.substring(2);
					
					newMonth = String.format("%02d", now.getMonthValue());
					
					product_no = returnList.get(i).toString();
					
					if(oldMonth != null && !oldMonth.equals(newMonth)) {
						product_no = productVO.getCategory_no() + productVO.getItem_no() + "-" + year + String.format("%02d", now.getMonthValue()) + 
    							"-P-" + "-00001";
					}else {
						int no = (Integer.parseInt(product_no.substring(14)));
						product_no = productVO.getCategory_no() + productVO.getItem_no() + "-" + year + String.format("%02d", now.getMonthValue()) + 
    							"-P-" + String.format("%05d", (no + 1));
					}
					
					productVO.setProduct_no(product_no);
				}
			}
			
			productService.setProductReg(productVO);

			obj.put("productNo", productVO.getProduct_no());
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
}
