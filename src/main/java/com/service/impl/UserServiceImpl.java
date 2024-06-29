package com.service.impl;

import com.entity.User;
import com.service.UserService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    @Override
    public void addUser(String newName) {
        String sql = "INSERT INTO 08User(name) VALUES(?)";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, newName);
            st.executeUpdate();
        }catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }

    @Override
    public List<User> listUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM 08User";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getObject("insert_time", LocalDateTime.class));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return users;
    }

    @Override
    public User getUser(String id) {
        User user = null;
        String sql = "SELECT * FROM 08User WHERE id=?";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, id);
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getString("id"), rs.getString("name"), rs.getObject("insert_time", LocalDateTime.class));
                }
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return user;
    }

}
