package com.example.registerlogin.model;

import com.example.registerlogin.entity.Account;
import com.example.registerlogin.entity.myenum.AccountStatus;
import com.example.registerlogin.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel{
    @Override
    public Account save(Account obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into accounts " +
                    "(username, passwordHash, salt, email, phone, role, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getPasswordHash());
            preparedStatement.setString(3, obj.getSalt());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setString(5, obj.getPhone());
            preparedStatement.setInt(6, obj.getRole());
            preparedStatement.setString(7, obj.getCreatedAt().toString());
            preparedStatement.setString(8, obj.getUpdatedAt().toString());
            preparedStatement.setInt(9, obj.getStatus().getValue());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Account obj = new Account(id, username, passwordHash, salt, email, phone, AccountStatus.of(status));
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setRole(role);
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findById(int id) {
        Account obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                int role = resultSet.getInt("role");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                obj = new Account(id, username, passwordHash, salt, email, phone, AccountStatus.of(status));
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Account findByUsername(String username) {
        Account obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where status = ? and username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.ACTIVE.getValue());
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                obj = new Account(id, username, passwordHash, salt, email, phone, AccountStatus.of(status));
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Account findByEmail(String email) {
        Account obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from accounts where email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int role = resultSet.getInt("role");
                String username = resultSet.getString("username");
                String passwordHash = resultSet.getString("passwordHash");
                String salt = resultSet.getString("salt");
                String phone = resultSet.getString("phone");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                obj = new Account(id, username, passwordHash, salt, email, phone, AccountStatus.of(status));
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Account update(int id, Account updateObj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update accounts " +
                    "set username = ?, passwordHash = ?, salt = ?, email = ?, phone = ?, role = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getUsername());
            preparedStatement.setString(2, updateObj.getPasswordHash());
            preparedStatement.setString(3, updateObj.getSalt());
            preparedStatement.setString(4, updateObj.getEmail());
            preparedStatement.setString(5, updateObj.getPhone());
            preparedStatement.setInt(6, updateObj.getRole());
            preparedStatement.setString(7, updateObj.getCreatedAt().toString());
            preparedStatement.setString(8, updateObj.getUpdatedAt().toString());
            preparedStatement.setInt(9, updateObj.getStatus().getValue());
            preparedStatement.setInt(10, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return updateObj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update accounts " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, AccountStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            System.out.println("Connection success!");
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
