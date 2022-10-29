package com.example.crudapi.service;


import com.example.crudapi.entity.Product;
import com.example.crudapi.entity.UserssEntity;
import com.example.crudapi.repository.ProductRepository;
import com.example.crudapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product p) {
        productRepository.save(p);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product sellProduct(Integer id, Integer quantity) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null){
            return null;
        }
        int result = product.getQuantity() - quantity;
        if (result < 0){
            return null;
        }
        product.setQuantity(result);
        return productRepository.save(product);
    }
}
