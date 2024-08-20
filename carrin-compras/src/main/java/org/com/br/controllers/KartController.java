package org.com.br.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.com.br.repositories.KartRepository;
import org.com.br.repositories.ProductRepository;

import org.com.br.service.KartService;
import org.com.br.vo.Kart;
import org.com.br.vo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KartController {

    @Autowired
    private KartService service;

    //@Autowired
    //private ProductRepository service1;

    private final ModelAndView model = new ModelAndView("kart");

    @RequestMapping("/kart")
    public ModelAndView showCarrinho(HttpServletRequest request) {
        try {
            List<Kart> lista = service.listUser(((Login) request.getSession().getAttribute("user")).getId());
            model.addObject("listaKart", lista);
            model.addObject("soma", lista.stream().map(item -> item.getValor_produto().multiply(item.getQuantidade())).mapToDouble(BigDecimal::doubleValue).sum());
        } catch (Exception e) {
        }
        return model;
    }

    @RequestMapping("/addItemKart")
    public ModelAndView addItemCarrinho(Kart kart, HttpServletRequest request) {
        try {
            kart.setUser((Login) request.getSession().getAttribute("user"));
            kart.setProduct(service.findProduct(Long.valueOf(request.getParameter("product_id"))));

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Kart>> violations = validator.validate(kart);
            if (violations.isEmpty()) {
                service.save(kart.geraValoresDefault());
                model.addObject("errorMessage", "Item adicionado com sucesso!");
            } else {
                for (ConstraintViolation<Kart> erro : violations) {
                    model.addObject("errorMessage", erro.getMessage());
                    break;
                }
            }
        } catch (Exception e) {
            model.addObject("errorMessage", "Erro inesperado! Tente novamente");

        }
        return showCarrinho(request);

    }
}
