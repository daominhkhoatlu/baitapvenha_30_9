package com.jdbc.baitapvenha.services;

import com.jdbc.baitapvenha.connection.DatabaseConnection;
import com.jdbc.baitapvenha.model.Category;
import com.jdbc.baitapvenha.model.Product;
import com.jdbc.baitapvenha.repository.ProductRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductRepo {
    @Override
    public boolean insertProduct(Product product) {
        String addProductQuery = "INSERT INTO Product(name, price, cat_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addProductQuery)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategory().getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        String addProductQuery = "UPDATE Product SET name = ?, price = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addProductQuery)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public List<Product> findProductsByCategory(String category_name) {
        List<Category> result = new ArrayList<>();
//
//        String query = "SELECT * FROM Product WHERE cat_id like ?"; // ? <=> '%To%'
//        try (Connection connection = DatabaseConnection.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) { // SELECT * FROM Category WHERE name like ? => tiep theo phai biet thang ? la thang nao
//            preparedStatement.setString(1, "%" + name + "%");
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                Category category = new Category();
//                int id_cate = rs.getInt("id");
//                String name_cate = rs.getString("name");
//                category.setId(id_cate);
//                category.setName(name_cate);
//                result.add(category);
//            }
//        } catch (SQLException e) {
//            DatabaseConnection.printSQLException(e);
//        }
        return null;
    }
}
