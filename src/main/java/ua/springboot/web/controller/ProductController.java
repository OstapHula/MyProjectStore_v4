package ua.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.entity.ProductEntity;
import ua.springboot.web.service.ProductService;

@Controller
@RequestMapping({"/catalog/product"})
public class ProductController {
    
    @Autowired private ProductService service;
    
    @GetMapping("/product/{productId}")
    public String showProduct(@PathVariable("productId") int productId, Model model){
	ProductEntity entity = service.findProductById(productId);
	model.addAttribute("title", "Home page");
	model.addAttribute("productModel", entity);
	return "product";
    }
    
}
