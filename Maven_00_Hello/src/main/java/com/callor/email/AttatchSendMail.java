package com.callor.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/*
 * java 1.8 이상
 */
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class AttatchSendMail {

	public static void main(String[] args) {
		String from = "callor@daum.net";
		String username = "callor";
		String pass = "ghfkdskql";
		String[] toAddress = new String[] { "callor@daum.net", "callor@callor.com", "callor88@naver.com" };
		String subject = "HTML Mail";
		String body = "<h1>대한민국 만세</h1>";

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

			message.setFrom(new InternetAddress(from));
			InternetAddress[] internetAddress = new InternetAddress[toAddress.length];

			// iterate array of addresses
			for (int i = 0; i < toAddress.length; i++) {
				internetAddress[i] = new InternetAddress(toAddress[i]);
			}

			for (int i = 0; i < internetAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, internetAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			String file = "src/main/java/com/callor/files/하트-퀸.png";
			String fileName = "플레잉카드 하트 퀸";
			
			FileDataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));

			
			// catch UnsupportedEncodingException
			messageBodyPart.setFileName(MimeUtility.encodeText(fileName));
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");

			transport.connect(host, from, pass);
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
