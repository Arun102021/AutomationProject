package com.hybrid.framework.platforms;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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
import com.hybrid.framework.execution.Execution;

public class EmailAttachment {

        public static Properties emailProperties;
        public static Session mailSession;
        public static MimeMessage message;
        // Create the message part
        public static BodyPart messageBodyPart;
        // Create message part for attaching file
        static BodyPart messageFilePart;

        // Create a multipart message
        static Multipart multipart;

        /*public static void main(String arg[]) throws AddressException,
                        MessagingException {*/
        @SuppressWarnings("static-access")
		public static void mail() throws AddressException, MessagingException {
                EmailAttachment javaEmail = new EmailAttachment();

                javaEmail.setMailServerProperties();
                javaEmail.createEmailMessage();
                javaEmail.sendEmail();
        }
        	
        public static void setMailServerProperties() {
        	
                // gmail's smtp port
                String emailPort = "587";
                emailProperties = System.getProperties();
                emailProperties.put("mail.smtp.port", emailPort);
                emailProperties.put("mail.smtp.auth", "true");
                emailProperties.put("mail.smtp.starttls.enable", "true");
        }		
        			
        public static void createEmailMessage() throws AddressException,
                        MessagingException {
                String[] toEmails = { "arunsubramani@merchantrms.com",};
                String emailSubject = Execution.SheetName1+ " Local Automation Test Result"; 
                String emailBody = "Please find the Local Automation Test Result in the attachment";
                
                // 1. Get the sesssion object
                mailSession = Session.getDefaultInstance(emailProperties, null);
                // 2. Compose message
                message = new MimeMessage(mailSession);
                
                for (int i = 0; i < toEmails.length; i++) {
                	message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
                }
				
                message.setSubject(emailSubject);
                
                // 3. Create MimeBodyPart object and set your message text
                messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(emailBody);
                
                // 4. Create new MimeBodyPart object and set DataHandler object to this
                // object - for attachment
                
                messageFilePart = new MimeBodyPart();

                String filename = "Test_Result.xlsx";
                String fileloc = "Test-result/Test_Result.xlsx";
                DataSource source = new FileDataSource(fileloc);
                messageFilePart.setDataHandler(new DataHandler(source));
                messageFilePart.setFileName(filename);
                
                // 5. Create Multipart object and add MimeBodyPart objects to this
                // object                	
                multipart = new MimeMultipart();	
                	
                // Set the body and file
                multipart.addBodyPart(messageBodyPart);
                multipart.addBodyPart(messageFilePart);
                
                // 6. set the multiplart object to the message object
                
                message.setContent(multipart);
        }		
        		
        public static void sendEmail() throws AddressException, MessagingException {
               
				@SuppressWarnings("unused")
				String emailHost = "smtp.gmail.com";

                //just the id alone without @ gmail.com
				String senderUsername = "arunsubramani@merchantrms.com";
                String senderEmailPassword = "Mrms@123";

                // 7. send message

                Transport transport = mailSession.getTransport("smtp");

                transport.connect(emailHost, senderUsername, senderEmailPassword);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("******Automation Result Sent To QA Successfully******.");
        }

}			