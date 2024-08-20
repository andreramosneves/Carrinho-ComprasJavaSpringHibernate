package org.com.br.service;

import org.com.br.repositories.LoginRepository;
import org.com.br.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public void save(Login login) {
        loginRepository.save(login);
    }

    public Login findByEmailPassword(String email, String password) {
        return loginRepository.findByEmail(email);
    }
}
