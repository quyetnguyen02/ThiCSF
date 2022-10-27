package com.example.crudapi.controller;


import com.example.crudapi.entity.Product;
import com.example.crudapi.entity.UserssEntity;
import com.example.crudapi.service.ProductService;
import com.example.crudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllUser() {
        List<Product> lsPro = productService.findAll();
        if(lsPro.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(lsPro, HttpStatus.OK);
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ResponseEntity<Product> saveNewUser(@RequestBody Product u) {
        productService.saveProduct(u);
        return new ResponseEntity<Product>(u, HttpStatus.OK);
    }

    //http://localhost:8080/updateUser?id=1
    @RequestMapping(value = "product", method = RequestMethod.PUT)
    public ResponseEntity<Product> sellProduct(
            @PathParam("id") Integer id,
            @PathParam("quantity") Integer quantity,
            @RequestBody Product u) {
        Product product = productService.sellProduct(id, quantity);
        if(quantity >= product.getQuantity()){
            return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
        }else{
            productService.saveProduct(product);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
