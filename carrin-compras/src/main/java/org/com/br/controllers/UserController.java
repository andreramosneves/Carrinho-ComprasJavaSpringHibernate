package org.com.br.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.com.br.repositories.LoginRepository;

import org.com.br.service.LoginService;
import org.com.br.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private LoginService service;

    private final ModelAndView model = new ModelAndView("login");

    @RequestMapping("/LoginController")
    public ModelAndView tentaLogar(@RequestParam("email") String user, @RequestParam("password") String senha, HttpServletRequest request) {

        Login login = service.findByEmailPassword(user, senha);
        /*Caso consiga verificamos o HASH  && BCrypt.checkpw(senha, login.getPassword() */
        if (login != null) {
            if(BCrypt.checkpw(senha, login.getPassword())){
                criaSessao(request, login);
                model.setViewName("redirect:home");
            }else{
                model.addObject("errorMessage", "Senha incorreta ou Usuário não encontrado! Registre-se ou tente novamente!");
                model.setViewName("login");
            }
        } else {
            model.addObject("errorMessage", "Senha incorreta ou Usuário não encontrado! Registre-se ou tente novamente!");
            model.setViewName("login");
        }
        return model;

    }

    private void criaSessao(HttpServletRequest request, Login login) {
        request.getSession().setAttribute("user", login);
    }

    @RequestMapping(value = "/RegisterController", method = RequestMethod.POST)
    public ModelAndView inseriUsuario(Login login) {
        ModelAndView model = new ModelAndView("registrar");
        /*Transformo minha senha num hash*/
		login.setPassword(BCrypt.hashpw(login.getPassword(), BCrypt.gensalt(10)));
		
		if (service.findByEmailPassword(login.getEmail(), login.getPassword()) == null){
			login.geraValoresDefault();
			service.save(login); 
			model.addObject("errorMessage", "Usuário cadastrado com sucesso!");
			return model;
		}
		model.addObject("errorMessage", "Usuário já cadastrado! Resete sua senha caso não lembre.");

        return model;

    }

    @RequestMapping("/registrar")
    public String registrarView() {
        return "registrar";
    }

    @RequestMapping({"/login", "/"})
    public String execute() {
        model.addObject("errorMessage", "");
        return "login";
    }

    @RequestMapping({"/logout"})
    public String logout(HttpServletRequest request) {
        model.addObject("errorMessage", "");
        request.getSession().invalidate();
        return "login";
    }

}
