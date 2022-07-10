package com.overone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private Connection connection;

    public List<Product> findAllProduct() {
        String query = "SELECT * FROM product";
        List<Product> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                result.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Product> findAllProductByMoney(Double money) {
        String query = "SELECT * FROM product WHERE price <= ?";
        List<Product> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, money);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                result.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
