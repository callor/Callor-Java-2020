package com.callor.email;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NaverSendMail {

	public static void main(String[] args) {

		// 네이버일 경우 smtp.naver.com 을 입력합니다. // Google일 경우 smtp.gmail.com 을 입력합니다.
		String host = "smtp.naver.com";
		final String username = "bizpoll_4800"; // 네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
		final String password = "eogksalsrnrakstp"; // 네이버 이메일 비밀번호를 입력해주세요.

		int port = 465; // 포트번호
		// 메일 내용
		String from = "bizpoll_4800@naver.com";
		String recipient = "callor88@naver.com"; // 받는 사람의 메일주소를 입력해주세요.
		String subject = "Naver Send"; // 메일 제목 입력해주세요.
		String body = String.format("<h1> Java Mail 로 메일보내기 <br> %s ", LocalDateTime.now()); // 메일 내용 입력해주세요.
		
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성

		// SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);

		// Session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;

			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);

		// for debug
		Message mimeMessage = new MimeMessage(session);

		// MimeMessage 생성
		try {
			
			// 발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
			// catch (UnsupportedEncodingException e) {
			mimeMessage.setFrom(new InternetAddress(from,"내멋으로",EncodingString.encoding_UTF8));
			// 수신자셋팅
			// .TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

			mimeMessage.setSubject(subject); // 제목셋팅

			mimeMessage.setText(body); // 텍스트로 보내기
			mimeMessage.setContent(body, "text/html;charset=" + EncodingString.encoding_UTF8);

			Transport.send(mimeMessage); // javax.mail.Transport.send() 이용

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
