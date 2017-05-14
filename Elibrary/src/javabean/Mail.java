package javabean;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javabean.MyEmailAutherticator;

public class Mail {
    
    //发送邮件的帐号和密码
    private String username="15991624805@163.com";

    private String password="yg19951109";
    
    private String host = "smtp.163.com";
    
    private String mail_head_name = "this is head of this mail";
    
    private String mail_head_value = "this is head of this mail";
    
    private String mail_to = "15991624805@163.com";
    
    private String mail_from = "15991624805@163.com";
    
    private String mail_subject = "网站邮件";
    
    private String mail_body = "this is mail_body of this test mail";
    
    private String personalName = "我的邮件";
    
    public void sendMail(String personalName,String mail_subject,String mail_body) throws SendFailedException{
        try {
             //发送邮件的props文件
            Properties props = new Properties();
            // 初始化props
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            System.out.println(props);
            
            //进行邮件服务用户认证
            Authenticator auth = new MyEmailAutherticator(username,password);
            
            // 创建session,和邮件服务器进行通讯
            Session session = Session.getDefaultInstance(props,auth);
            
            // 创建mime类型邮件
            MimeMessage message = new MimeMessage(session);
            //设置邮件格式
            message.setContent("Hello","text/html;charset=utf-8");
            // 设置主题
            message.setSubject(mail_subject);
            //设置邮件内容
            message.setText(mail_body);
            //设置邮件标题
            message.setHeader(mail_head_name, mail_head_value);
            message.setSentDate(new Date());//设置邮件发送时期
            Address address = new InternetAddress(mail_from,personalName);
            //设置邮件发送者的地址
            message.setFrom(address);
            
            //======单发邮件======
            //设置邮件接收者的地址
            Address toaddress = new InternetAddress(mail_to);
            // 设置收件人
            message.addRecipient(Message.RecipientType.TO,toaddress);
            
            //======群发邮件======
//            List<String> recipients = new ArrayList<String>();
//            recipients.add("123456789@qq.com");
//            recipients.add("234567890@gmail.com");
//            final int num = recipients.size();
			// InternetAddress[] addresses = new InternetAddress[num];
			// for (int i = 0; i < num; i++) {
//                addresses[i] = new InternetAddress(recipients.get(i));
//            }
//            message.setRecipients(Message.RecipientType.TO, addresses);
            

            //System.out.println(message);
            // 发送邮件
            Transport.send(message);
            System.out.println("Send Mail Ok!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}