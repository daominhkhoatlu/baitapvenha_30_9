package com.jdbc.baitapvenha.repository;

import com.jdbc.baitapvenha.model.Product;

import java.util.List;

public interface ProductRepo {
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> findProductsByCategory(String category_name);

}
