package kr.co.shop.util;

import javax.mail.PasswordAuthentication;

public class MailAuthUtil {
	
	//비밀번호 인증
	static PasswordAuthentication pa;
	
	//파라미터 있는 경우 생성자
    public MailAuthUtil(String id, String pw) {  	
    	String sendId =id ; 
    	String sendPw =pw;
        System.out.println("sendId -> " + sendId);
        System.out.println("sendPw -> " + sendPw);
        pa = new PasswordAuthentication(sendId, sendPw);
    }
    
    //발송단계에서 인증 정보를 확인할 수 있음
    public static PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}