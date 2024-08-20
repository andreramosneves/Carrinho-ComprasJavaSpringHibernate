/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.com.br.service;

import java.util.List;
import java.util.Optional;
import org.com.br.repositories.ProductRepository;
import org.com.br.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */

@Component 
public class ProductService {

    @Autowired
    private ProductRepository dao;

    public void save(Product produto) {
        dao.save(produto);
    }

    public List<Product> list() {
        return dao.findByDtterminoNull();
    }

    public Product find(Long parseInt) {
        Optional<Product> p = dao.findById(parseInt);
        return p.get();
    }

}
