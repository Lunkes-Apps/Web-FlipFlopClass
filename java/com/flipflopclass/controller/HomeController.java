package com.flipflopclass.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flipflopclass.model.Account;
import com.flipflopclass.model.CadastroUser;
import com.flipflopclass.model.Estudo;
import com.flipflopclass.model.User;
import com.flipflopclass.model.VerificationToken;
import com.flipflopclass.repository.AccountRepository;
import com.flipflopclass.repository.EstudosRepository;
import com.flipflopclass.repository.TokenRepository;
import com.flipflopclass.repository.UserRepository;


@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired
	private EstudosRepository estudosRepo;
	
	@Autowired
	AccountRepository accounts;

	@Autowired
	UserRepository users;
	
	@Autowired
	TokenRepository tokens;

	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	CadastroUser cadastroUser;
	
	@ModelAttribute("cadastroUser")
	public CadastroUser cadastroUser(){
		return cadastroUser;
	}
	
	@RequestMapping()
	public ModelAndView home(){		
		List<Estudo> estudos = estudosRepo.findAll();
		
		ModelAndView mv = new ModelAndView("home");
		
		CadastroUser c = new CadastroUser();
		
		mv.addObject("estudos",estudos);
				
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String cadastrar(@Validated @ModelAttribute("cadastroUser") CadastroUser cadastroUser, BindingResult bindingResult){
		
		User user = new User();
		Account account = new Account();
		
        user.setUsername(cadastroUser.getUsername());
        user.setPassword(cadastroUser.getPassword());
        user.setAuthorit("ROLE_USER");
        user.setEnabled(false);
        
        account.setNome(cadastroUser.getNome());
        
        String token = UUID.randomUUID().toString();

		VerificationToken tokenV = new VerificationToken();

		Calendar cal = Calendar.getInstance();

        
		//preparando o email
		
		String recipientAddress = user.getUsername();
		String subject = "Confirmação de cadastro no site FlipFlop Class";
		String confirmationUrl = "/home/registrationOfToken?token=" + token;
		
		SimpleMailMessage email = new SimpleMailMessage();
                
		email.setTo(recipientAddress);
		email.setSubject(subject);
		Locale locale = new Locale("pt", "BR");
		
		email.setText("Este email foi enviado para confirmação de conta no site FlipFlop Class\n " +
				" Clique neste link para confirmar sua inscrição: " + "http://localhost:8080"
						+ confirmationUrl);
				
		
		users.save(user);
		account.setUser(user);
        accounts.save(account);
        tokenV.setToken(token);
        tokenV.setUser(account);
        tokenV.setExpiryDate(cal.getTime());
		tokens.save(tokenV);	

		mailSender.send(email);
		
        clearCadastroUser();
        		
		return "redirect:/home";
	}

	private void clearCadastroUser() {
		cadastroUser.setNome("");
		cadastroUser.setUsername("");
		cadastroUser.setPassword("");
	}
	
		
	
}
