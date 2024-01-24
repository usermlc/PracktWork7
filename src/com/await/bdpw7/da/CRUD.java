package com.await.bdpw7.da;

import java.sql.*;

public class CRUD {

    public void insert(String name, Double price) {
        String sql = "INSERT INTO menu(name,price) VALUES(?,?)";

        try (Connection conn = ConnectToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, String name, Double price){
        String sql = "UPDATE menu SET name = ? , "
                + "price = ? "
                + "WHERE id = ?";

        try (Connection conn = ConnectToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void read(){
        String sql = "SELECT id, name, price FROM menu";

        try (Connection conn = ConnectToDB.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(int id){
        String sql = "DELETE FROM menu WHERE id = ?";

        try (Connection conn = ConnectToDB.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
