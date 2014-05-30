/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ays.plugins;

/**

 @author metin
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test_EmailSend {

    public static void main (String[] args) {

        /**
         http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
         Library'e mail.jar import edilmeli.
         http://www.oracle.com/technetwork/java/javamail/index.html adresinden indirilebilir.
         */
        final String username = "boylebiradresyok@gmail.com";
        final String password = "sifresineyse";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication () {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("boylebiradresyok@gmail.com")); // GONDEREN ADRES
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("istememyancebimekoy@gmail.com")); // ALICI ADRES
            message.setSubject("Konu yok!"); // MAIL KONUSU
            message.setText("Sayin mail alicisi," // MAIL GOVDESI
                    + "\n\nTest mailidir korkmayiniz!");

            Transport.send(message);

            System.out.println("Gonderildi.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
