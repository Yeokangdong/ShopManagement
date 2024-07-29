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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.co.shop.service.CompanyService;
import kr.co.shop.service.EmailService;
import kr.co.shop.service.OrderService;
import kr.co.shop.util.Util;
import kr.co.shop.vo.CompanyVO;
import kr.co.shop.vo.EmailVO;
import kr.co.shop.vo.OrderVO;

@Controller
public class EmailController {

	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name = "emailService")
	private EmailService emailService;
	
	@Resource(name = "companyService")
	private CompanyService companyService;
	
	private EmailVO emailVO;

	/**
	 * 전송 이메일 등록
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/setEmailReg.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String setEmailReg(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		for (String id: paramMap.keySet()) {
			paramMap.put(id, paramMap.get(id));
        }

		String email_title = paramMap.get("email_title").toString();
		String email_content = paramMap.get("email_content").toString();

		emailVO = new EmailVO();
		emailVO.setEmail_title(email_title);
		emailVO.setEmail_content(email_content);
		
		JSONObject obj = new JSONObject();
		
		try{
			
			emailService.setEmailReg(emailVO);
			
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 이메일 정보
	 * @param model
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getOrderEmailInfo.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String getOrderEmailInfo(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {
		
		JSONObject obj = new JSONObject();
		
		try{
			
			List<String> returnList = (List<String>) emailService.getOrderEmailInfo();
			
			obj.put("returnList", returnList);
			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
	
	/**
	 * 이메일 전송
	 * @param model
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/sendEmail.do", method = {RequestMethod.POST}, produces = "application/text; charset=utf8")
	public @ResponseBody String sendEmail(@RequestParam Map<String, Object> paramMap, HttpServletRequest request, ModelMap model) throws Exception {

		List<HashMap<String, Object>> returnExcelList = new ArrayList<>(); 
		List<OrderVO> returnList = null;
		
		JSONObject obj = new JSONObject();
		
		try{

			String orderChkArr = paramMap.get("orderChkArr").toString();
			orderChkArr = orderChkArr.replaceAll("&quot;", "\"");
			String[] list = orderChkArr.split(",");

			for (int i = 0; i < list.length; i++) {
				String order_no = list[i].replace("[", "");
				order_no = order_no.replace("]", "");
				order_no = order_no.substring(1);
				order_no = order_no.substring(0, order_no.length() - 1);
				
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("order_no", order_no);
				map.put("start_num", 0);
				
				returnList = (List<OrderVO>) orderService.getOrderList(map);
			
				if(returnList.size() > 0) {
					for(int j = 0; j < returnList.size(); j++) {
						String product_no = (returnList.get(j).getProduct_no()!=null)?returnList.get(j).getProduct_no().toString():"";
						String option_no = (returnList.get(j).getOption_no()!=null)?returnList.get(j).getOption_no().toString():"";
						String receive_nm = (returnList.get(j).getReceive_nm()!=null)?returnList.get(j).getReceive_nm().toString():"";
						String receive_tel = (returnList.get(j).getReceive_tel()!=null)?returnList.get(j).getReceive_tel().toString():"";
						String receive_tel_etc = (returnList.get(j).getReceive_tel_etc()!=null)?returnList.get(j).getReceive_tel_etc().toString():"";
						String receive_address = (returnList.get(j).getReceive_address()!=null)?returnList.get(j).getReceive_address().toString():"";
						String send_nm = (returnList.get(j).getSend_nm()!=null)?returnList.get(j).getSend_nm().toString():"";
						String send_tel = (returnList.get(j).getSend_tel()!=null)?returnList.get(j).getSend_tel().toString():"";
						String send_tel_etc = (returnList.get(j).getSend_tel_etc()!=null)?returnList.get(j).getSend_tel_etc().toString():"";
						String send_address = (returnList.get(j).getSend_address()!=null)?returnList.get(j).getSend_address().toString():"";
						String product_title = (returnList.get(j).getProduct_title()!=null)?returnList.get(j).getProduct_title().toString():"";
						String box_cnt = (returnList.get(j).getBox_cnt()!=null)?returnList.get(j).getBox_cnt().toString():"";
						String message = (returnList.get(j).getMessage()!=null)?returnList.get(j).getMessage().toString():"";
						String modify_dt = (returnList.get(j).getModify_dt()!=null)?returnList.get(j).getModify_dt().toString():"";
						String create_dt = (returnList.get(j).getCreate_dt()!=null)?returnList.get(j).getCreate_dt().toString():"";
				
						HashMap<String, Object> orderMap = new HashMap<String, Object>();
						orderMap.put("order_no", order_no);
						orderMap.put("product_no", product_no); 
						orderMap.put("option_no", option_no);
						orderMap.put("receive_nm", receive_nm);
						orderMap.put("receive_tel", receive_tel);
						orderMap.put("receive_tel_etc", receive_tel_etc);
						orderMap.put("receive_address", receive_address);
						orderMap.put("send_nm", send_nm);
						orderMap.put("send_tel", send_tel);
						orderMap.put("send_tel_etc", send_tel_etc);
						orderMap.put("send_address", send_address);
						orderMap.put("product_title", product_title);
						orderMap.put("box_cnt", box_cnt);
						orderMap.put("message", message);
						orderMap.put("modify_dt", modify_dt);
						orderMap.put("create_dt", create_dt);
						
						returnExcelList.add(i, orderMap);
					}
				}
			}
			
			for (String id: paramMap.keySet()) {
				paramMap.put(id, paramMap.get(id));
	        }
			
			String email_title = paramMap.get("email_title").toString();
			String email_content = paramMap.get("email_content").toString();
			String company_no = paramMap.get("company_no").toString();
			
			Map<String, Object> map = paramMap;
			map.put(company_no, company_no);
			
			List<CompanyVO> companyInfo = (List<CompanyVO>) companyService.getCompanyInfo(map);
			
			Properties props = new Properties();
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.naver.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.ssl.trust", "smtp.naver.com");
			props.put("mail.smtp.auth", "true");
			
			InternetAddress[] receiverList = new InternetAddress[1];
			receiverList[0] = new InternetAddress(companyInfo.get(0).getEmail());
			
			HttpSession session = request.getSession();
			
			Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(session.getAttribute("email").toString(), session.getAttribute("email_password").toString());
				}
			});
			
			Message mimeMessage = new MimeMessage(mailSession);
			mimeMessage.setFrom(new InternetAddress(session.getAttribute("email").toString()));
			mimeMessage.setRecipients(Message.RecipientType.TO, receiverList);
			mimeMessage.setSubject(email_title);
			mimeMessage.setContent(email_content, "text/html; charset=UTF-8");
			
			// 메일 콘텐츠 설정
		    Multipart mParts = new MimeMultipart();
		    MimeBodyPart mTextPart = new MimeBodyPart();
		 
		    // 메일 콘텐츠 - 내용
		    /**********************************************
		     * 본문 처리
		     **********************************************/
		    mTextPart.setText(email_content, "UTF-8", "html"); 
		    mParts.addBodyPart(mTextPart);
		    	
	    	MimeBodyPart attachPart = new MimeBodyPart();
		    
	    	Util.orderAttachExcel(returnExcelList);
	    	
	    	DataSource source = new FileDataSource("D:\\Shop\\임시저장\\주문.xlsx");
		    attachPart.setDataHandler(new DataHandler(source));
		    
		    //파일명칭이 깨지지 않도록 조치를 취함
		    try {
		    	
				attachPart.setFileName(MimeUtility.encodeText(source.getName(), "euc-kr","B"));
				mParts.addBodyPart(attachPart);	  
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		    
		    mimeMessage.setContent(mParts);
	 
		    // MIME 타입 설정
		    MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		    MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		    MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		    MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		    MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		    MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		    CommandMap.setDefaultCommandMap(MailcapCmdMap);
				
			// Mail 발송
			Transport.send(mimeMessage);
			
			//임시 저장된 파일 삭제
			File file = new File("D:\\Shop\\임시저장\\주문.xlsx");
	        
	    	if( file.exists() ){
	    		if(file.delete()){
	    			System.out.println("파일삭제 성공");
	    		}else{
	    			System.out.println("파일삭제 실패");
	    		}
	    	}else{
	    		System.out.println("파일이 존재하지 않습니다.");
	    	}

			obj.put("message", "success");
		}catch(Exception error){
			obj.put("message", "fail");
			obj.put("error", error.getMessage().toString());
		}
		
		return obj.toString();
	}
}
