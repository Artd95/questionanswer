package questionanswer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Value("${spring.mail.username}")
    String username;

    @Autowired
    JavaMailSender mailSender;

    public String sendMessage(String nameTo, String topic, String letter)
    {
        SimpleMailMessage smm= new SimpleMailMessage();
        smm.setFrom(username);
        smm.setTo(nameTo);
        smm.setSubject(topic);
        smm.setText(letter);


        mailSender.send(smm);
        return "sendMessage";}
}
