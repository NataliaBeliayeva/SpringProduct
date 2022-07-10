package com.overone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDao {

    @Autowired
    private Connection connection;

    public Double findUserMoneyById(int id){
        String query = "SELECT money FROM user WHERE id = ?";
        Double result = 0.0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                result = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
