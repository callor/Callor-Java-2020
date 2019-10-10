package com.callor.email;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MultiMailSend {

	public static void main(String[] args) {

		String from = "callor@daum.net";
		String username = "callor";
		String pass = "ghfkdskql";
		String[] toAddress = new String[] { "callor@daum.net", "callor@callor.com", "callor88@naver.com" };
		String subject = "HTML Mail";

		Properties properties = System.getProperties();
		String host = "smtp.daum.net";


		// ??
		properties.put("mail.smtp.starttls.enable", "true");

		// SMTP 서버 정보 설정
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.trust", host);
		properties.put("mail.smtp.user", username);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(properties);
		session.setDebug(true); // for debug
		MimeMessage message = new MimeMessage(session);

		try {

			message.setFrom(new InternetAddress(from, username, EncodingString.encoding_UTF8));
			InternetAddress[] internetAddress = new InternetAddress[toAddress.length];

			// iterate array of addresses
			for (int i = 0; i < toAddress.length; i++) {
				internetAddress[i] = new InternetAddress(toAddress[i]);
			}

			for (int i = 0; i < internetAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, internetAddress[i]);
			}

			message.setSubject(subject);
//			message.setContent(body, "text/html;charset=" + EncodingString.encoding_UTF8);

			String msg = new String();
			for (int i = 0; i < 10; i++) {
				msg += String.format("<h1>  %d Java Mail 로 메일보내기  %s <br>", i + 1, LocalDateTime.now());
				for(int j = 0 ; j < 1000 ; j++);
			}

			message.setContent(msg, "text/html;charset=" + EncodingString.encoding_UTF8);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
