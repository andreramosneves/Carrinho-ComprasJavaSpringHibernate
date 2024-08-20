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
import org.com.br.repositories.OrderRepository;
import org.com.br.service.KartService;

import org.com.br.service.OrderService;
import org.com.br.vo.Kart;
import org.com.br.vo.Login;
import org.com.br.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private ModelAndView model = new ModelAndView("order");

    @Autowired
    private OrderService orderService;


    @RequestMapping("/order")
    public ModelAndView mostraPedidos(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            model.addObject("errorMessage", "É necessário estar logado!");
            return model;
        }
        model.addObject("listaPedidos", orderService.listaPedidosPorUsuario(((Login) request.getSession().getAttribute("user")).getId()));
        model.addObject("errorMessage", "");

        return model;
    }

    @RequestMapping("/finalizarPedido")
    public ModelAndView finalizaPedido(HttpServletRequest request) {
        try {
            List<Kart> carrinho = orderService.listUser(((Login) request.getSession().getAttribute("user")).getId());
            System.out.println(carrinho.size());
            Order order = new Order();
            order.setUser((Login) request.getSession().getAttribute("user"));
            order.setTotal(carrinho.stream().map(item -> item.getValor_produto().multiply(item.getQuantidade())).mapToDouble(BigDecimal::doubleValue).sum());

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Order>> violations = validator.validate(order);
            if (violations.isEmpty()) {
                orderService.save(order.geraValoresDefault());
                for (Kart item : carrinho) {
                    item.setOrder(order);
                    orderService.saveKart(item);
                }

                model.addObject("errorMessage", "Pedido finalizado com sucesso!");
            } else {
                for (ConstraintViolation<Order> erro : violations) {
                    model.addObject("errorMessage", erro.getMessage());
                    break;
                }
            }
        } catch (Exception e) {
        }

        return model;
    }

}
