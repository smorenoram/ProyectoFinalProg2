package co.edu.unbosque.proyectoFinal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mail;
	String codigo = "5";
	
	
	public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no.reply.easy.cooking@gmail.com");
        message.setTo(to);
        message.setSubject("confirmacion de cuenta");
        message.setText("su cuenta ha sido creada con exito en Easy Cooking!, este es su codigo de verificacion" + "\n" + codigo);

        mail.send(message);
    }


}