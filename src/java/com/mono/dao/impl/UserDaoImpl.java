package com.mono.dao.impl;

import com.mono.connect.MSSQLConnection;
import com.mono.dao.BaseDao;
import com.mono.dao.UserDao;
import com.mono.entity.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prongbang
 */
public class UserDaoImpl implements BaseDao<Users, Integer>, UserDao {

    private Connection conn = null;
    private MSSQLConnection connection = null;

    public UserDaoImpl() throws Exception {

        connection = new MSSQLConnection();
        conn = connection.getDefaultConnection(false);

    } 
    
    @Override
    public int insert(Users user) throws Exception {
        String sql = "";

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        sql += "INSERT INTO Users ";
        sql += "(id, name, surname) ";
        sql += "VALUES ";
        sql += "(" + user.getId() + ",'" + user.getName() + "','" + user.getSurname() + "')";

        System.out.println(sql);

        return stmt.executeUpdate(sql);
    }

    @Override
    public int update(Users user) throws Exception {
        String set = "";
        String sql = "";

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        // Choose data is not null
        if (user.getName() != null) {
            set += ", name = '" + user.getName() + "'";
        }
        if (user.getSurname() != null) {
            set += ", surname = '" + user.getSurname() + "'";
        }

        // Preare SQL
        sql += "UPDATE Users ";
        sql += "SET ";
        sql += set.substring(1);
        sql += " ";
        sql += "WHERE ";
        sql += "id = " + user.getId();

        return stmt.executeUpdate(sql);
    }

    @Override
    public int delete(Users user) throws Exception {
        String sql = "";

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        sql += "DELETE FROM Users ";
        sql += "WHERE ";
        sql += "id = " + user.getId();

        return stmt.executeUpdate(sql);
    }

    @Override
    public List<Users> findAll() throws Exception {
        List<Users> users = new ArrayList<>();

        String sql = "SELECT * FROM Users";
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            Users user = new Users();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));

            // Add Users Object เข้าไปเก็บใน List ที่มีโครงสร้างแบบ Object Users
            users.add(user);
        }
        return users;
    }

    @Override
    public Users findByPK(Integer pk) throws Exception {
        String sql = "SELECT * FROM Users WHERE id = " + pk;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        Users user = new Users();
        if (rs.next()) { 
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname")); 
        }
        return user;
    }

    @Override
    public Integer findLastPK() throws Exception {
        
        return 0;
    }

}
