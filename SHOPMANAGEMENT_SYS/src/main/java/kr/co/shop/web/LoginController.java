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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.co.shop.service.LoginService;
import kr.co.shop.vo.LoginVO;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
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
public class LoginController {
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	private LoginVO usersVo;
	
	/**
	 * 로그인 한다
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public void login(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String returnURL = "";
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		String admin_yn = request.getParameter("admin_yn");
		
		//HTTP_REFERER 체크하기
        String beforeUrl = request.getHeader("Referer");
        session.setAttribute("Referer",beforeUrl);
        
		System.out.println("==============BEFORE===============" + beforeUrl + "==========================");
		
		//ajax에서 왔는지 확인 */
		if("true".equals(request.getHeader("AJAX"))) {
			System.out.println("==============AJAX===============" + request.getHeader("AJAX") + "========================");
		}
        	
    	String reqUrl = request.getRequestURL().toString();
    	System.out.println("-----------------> Url check Interceptor , reqUrl : " +reqUrl );
    	
    	//if(reqUrl.equals("특정url")){
    		//return false;
    	//}
    	//ajax방식이 아닐때 사용
        //String returnURL = "";
        if (session.getAttribute("loginInfo") != null ) {        	
            //기존에 login 세션 값이 존재한다면
        	//기존값을 제거해 준다.        	
            session.removeAttribute("loginInfo");
        }
        
        //로그인이 성공하면 UsersVO 객체를 반환함.
        usersVo = new LoginVO();
        usersVo.setUser_id(user_id);
        usersVo.setUser_password(user_password);

        @SuppressWarnings("unchecked")
		List<LoginVO> usersList = (List<LoginVO>) loginService.getUserInfo(usersVo);
        
        if (usersList != null && usersList.size() > 0) {
        	System.out.println("============test===========로그인성공=============================");
        	
        	session.setAttribute("user_id", usersList.get(0).getUser_id());
        	session.setAttribute("user_password", usersList.get(0).getUser_password());
        	session.setAttribute("email", usersList.get(0).getEmail());
        	session.setAttribute("email_password", usersList.get(0).getEmail_password());
        	session.setAttribute("phone_number", usersList.get(0).getPhone_number());
        	session.setAttribute("admin_yn", usersList.get(0).getAdmin_yn());
        	session.setAttribute("create_dt", usersList.get(0).getCreate_dt());
        	
        	//세션시간
        	session.setMaxInactiveInterval(30 * 6000);
        	
            usersVo.setEmail(usersList.get(0).getEmail());
            usersVo.setEmail(usersList.get(0).getPhone_number());
            usersVo.setEmail(usersList.get(0).getAdmin_yn());
            usersVo.setEmail(usersList.get(0).getCreate_dt());
        	
        	//로그인 성공
        	//세션에 login인이란 이름으로 UsersVO 객체를 저장해 놈.
            session.setAttribute("loginInfo", usersList.get(0));
            //로그인 성공시 메인페이지로 이동하지만 ajax방식이 아닐때 사용
            returnURL = "redirect:/index";
            
            try {
                response.getWriter().write("true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
        	//로그인에 실패한 경우
        	//로그인 폼으로 다시 가도록 함  ajax방식이 아닐때 사용
            //returnURL = "redirect:/login/loginForm";
        	
            try {
                response.getWriter().write("false");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //위에서 설정한 returnURL 을 반환해서 이동시킴
        //return returnURL;
    }
 
    //로그아웃하는 부분
	@RequestMapping(value = "/logout.do", method=RequestMethod.POST)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {  	
    	
		//로그아웃후 로그인 화면으로 이동
        session.invalidate();        
        return "redirect:/index.do";
    }
}
