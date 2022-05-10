package org.com.br.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//	
//	 @RequestMapping(value = "/index", method = RequestMethod.GET)
//	 public String home(Model model) {
//        model.addAttribute("mensagem",
//                "Minha primeira aplicação utilizando o Spring Framework MVC!");
//        return new ModelAndView("index");
//    }
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	    public String welcome() {
	        return "index";
	 }
	
}
