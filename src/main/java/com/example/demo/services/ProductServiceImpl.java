package com.example.demo.services;

import com.example.demo.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void createProduct(Product product) {

    }

    @Override
    public void updateProduct(String id, Product product) {

    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public Collection<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProduct(String id) {
        return null;
    }
}
