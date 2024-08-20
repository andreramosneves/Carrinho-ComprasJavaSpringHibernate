/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.com.br.service;

import java.util.List;
import org.com.br.repositories.OrderRepository;
import org.com.br.repositories.KartRepository;
import org.com.br.vo.Order;
import org.com.br.vo.Kart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */
@Component 
public class OrderService {
    
	@Autowired
	private OrderRepository dao;
	
	@Autowired
	private KartRepository daoKart;    

    public List<Order> listaPedidosPorUsuario(int id) {
        return dao.listaPedidosPorUsuario(id);
    }

    public void save(Order geraValoresDefault) {
        dao.save(geraValoresDefault);
    }

    public List<Kart> listUser(int id) {
        return daoKart.listUser(id);
    }
    public void saveKart(Kart kart) {
        daoKart.save(kart);
    }
    
}
