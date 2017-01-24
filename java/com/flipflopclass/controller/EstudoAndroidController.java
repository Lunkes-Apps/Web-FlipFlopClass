package com.flipflopclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flipflopclass.model.CadastroUser;
import com.flipflopclass.model.Estudo;
import com.flipflopclass.repository.EstudosRepository;

@Controller
@RequestMapping(value = "/estudos-android")
public class EstudoAndroidController {
	
	@Autowired
	public EstudosRepository estudosRepo;
	
	@Autowired
	CadastroUser cadastroUser;
	
	@ModelAttribute("cadastroUser")
	public CadastroUser cadastroUser(){
		return cadastroUser;
	}
	
	
	@RequestMapping()
	public ModelAndView android(){
		
		List<Estudo> estudos = estudosRepo.findByModuloNome("Android Básico");
				
		ModelAndView mv = new ModelAndView("estudos");
		
		mv.addObject("estudos",estudos);
		
		return mv;
	}
	
	@RequestMapping(value="/{codigo}")
	public ModelAndView video(@PathVariable("codigo") int codigo){
		
				
		Estudo estudo = estudosRepo.findByCodigo(codigo);		
		
		
		ModelAndView mv = new ModelAndView("tela-video-estudo");
		mv.addObject("estudo",estudo);		
		
		return mv;
	}
	
	
	public class DadosSuport{
	    private String titulo;
	    private String link;
		
	    public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
	    	    
	    
	}

}
