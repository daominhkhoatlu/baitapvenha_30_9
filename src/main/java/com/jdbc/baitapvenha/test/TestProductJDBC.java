package com.jdbc.baitapvenha.test;


import com.jdbc.baitapvenha.model.Category;
import com.jdbc.baitapvenha.model.Product;
import com.jdbc.baitapvenha.repository.CategoryRepo;
import com.jdbc.baitapvenha.repository.ProductRepo;
import com.jdbc.baitapvenha.services.CategoryService;
import com.jdbc.baitapvenha.services.ProductService;

import java.util.List;

public class TestProductJDBC {
    public static void main(String[] args) {
        CategoryRepo categoryRepo = new CategoryService();
        ProductRepo productRepo = new ProductService();

        Category category = new Category("Test Category Insert Product");
        Product product = new Product("Product New", 100.05);
        // kiem tra category co ton tai trong DB hay khong?
        if (categoryRepo.checkIsExistCategory(category.getName())) {
            List<Category> categories = categoryRepo.findCategoryByName(category.getName()); //luon luon tra ve 1 phan tu
            Category cat = categories.get(0);
            product.setCategory(cat);
            if (productRepo.insertProduct(product)) {
                System.out.println("Insert Product Successfully.");
            } else {
                System.out.println("Insert Product Failed.");
            }
        } else {
            categoryRepo.save(category);
            List<Category> categories = categoryRepo.findCategoryByName(category.getName()); //luon luon tra ve 1 phan tu
            Category cat = categories.get(0);
            product.setCategory(cat); // co gia tri; Test Category Insert Product
            if (productRepo.insertProduct(product)) {
                System.out.println("Insert Product Successfully.");
            } else {
                System.out.println("Insert Product Failed.");
            }
        }

    }
}