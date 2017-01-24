package com.flipflopclass;

import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.flipflopclass.model.CadastroUser;



@SpringBootApplication
@Configuration
public class FlipflopclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipflopclassApplication.class, args);
		
	}
	
	@Bean
	public JavaMailSender getMailSender(){
		
		JavaMailSenderImpl emailImp = new JavaMailSenderImpl();
		emailImp.setHost("smtp.gmail.com");
		emailImp.setPort(587);
		emailImp.setUsername("flipflopclass.dev@gmail.com");
		emailImp.setPassword("habemusFlipFlopClass");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		
		emailImp.setJavaMailProperties(javaMailProperties);
		
		return emailImp;
	}

	
	@Bean(name = "cadastroUser")	
	public CadastroUser cadastro(){
		System.out.print(">>>>>>>>>>>>>>>>>>> foi feito ");
		return new CadastroUser();
	}
	
	
}
