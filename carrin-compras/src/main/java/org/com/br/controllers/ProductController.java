package org.com.br.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.com.br.repositories.ProductRepository;

import org.com.br.service.ProductService;
import org.com.br.vo.Login;
import org.com.br.vo.Product;
import org.com.br.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    private ModelAndView view = new ModelAndView("products");

    @RequestMapping("/products")
    public ModelAndView productView(@RequestParam(required = false) String id) {
        view.setViewName("products");
        if (id != null) {
            try {
                Product p = service.find(Long.valueOf(id));
                view.addObject("produto", p);
            } catch (NumberFormatException e) {
            }
        }
        List<Product> listaProdutos = service.list();
        view.addObject("listaProdutos", listaProdutos);
        return view;
    }

    @RequestMapping("/home")
    public ModelAndView homeView() {
        view.setViewName("home");
        List<Product> listaProdutos = service.list();
        view.addObject("listaProdutos", listaProdutos);
        return view;
    }

    @RequestMapping("/inseriProduto")
    public ModelAndView inseriProduto(Product produto, @RequestParam("i_product") MultipartFile multipartFile) {
        view.setViewName("products");
        produto.geraValoresDefault();
        if (!multipartFile.isEmpty()) {
            produto.setPhoto(produto.getCreated_at().replaceAll(":", "").replaceAll(" ", "").replaceAll("-", "") + "." + StringUtils.getFilenameExtension(multipartFile.getOriginalFilename()));
        }
        service.save(produto);
        String newFile = produto.getId() + produto.getCreated_at().replaceAll(":", "").replaceAll(" ", "").replaceAll("-", "")
                + "." + StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
        /*Cria pasta na raiz C:\\*/
        String uploadDir = "/carrin-compras/media/produtos/";
        try {
            if (!multipartFile.isEmpty()) {
                FileUploadUtil.saveFile(uploadDir, newFile, multipartFile);
                produto.setPhoto(newFile);
                service.save(produto);
            }
            view.addObject("errorMessage", "Produto salvo com sucesso!");
            view.addObject("listaProdutos", service.list());
        } catch (IOException e) {
            view.addObject("errorMessage", "Erro ao salvar o produto");
        }
        return view;
    }

    @RequestMapping("/finalizaProduto")
    public ModelAndView finalizaProduto(@RequestParam String id, HttpSession session) {
        Login user = (Login) session.getAttribute("user");
        if (user != null && user.getUser_type().equalsIgnoreCase("admin")) {
            Product p = service.find(Long.valueOf(id));
            if (p != null && p.getDt_termino() == null) {
                service.save(service.find(Long.valueOf(id)).finalizaProduto());
                view = productView(null);
                view.addObject("errorMessage", "Produto encerrado com sucesso!");
                view.setViewName("products");

            }
        } else {
            view.addObject("errorMessage", "Você não tem permissão para acessar essa página!");
            view.setViewName("login");
        }
        return view;

    }

}
