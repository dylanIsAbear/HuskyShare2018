package com.example.demo.services;

import com.example.demo.Entity.Product;

import java.util.Collection;

public interface ProductService{
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
    public abstract Product getProduct(String id);
}
