/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.com.br.service;

import java.util.List;
import org.com.br.repositories.KartRepository;
import org.com.br.repositories.ProductRepository;
import org.com.br.vo.Kart;
import org.com.br.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */

@Component 
public class KartService {
    
    @Autowired
    private KartRepository daoKart;
    @Autowired
    private ProductRepository daoProduct;

    
    public List<Kart> listUser(int id) {
        return daoKart.listUser(id);
    }

    public Product findProduct(Long parseInt) {
        return daoProduct.findById(parseInt).get();
    }

    public void save(Kart kart) {
        daoKart.save(kart);
    }



}
