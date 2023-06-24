package com.quiz.Model;

import java.sql.*;

public class ProfileInformation {

    private int ID;
    private String Age;
    private String Address;
    private String Phonenumber;

    public ProfileInformation(int ID, String age, String address, String phonenumber) {
        getID(ID);
        getAddress(address);
        getAge(age);
        getPhonenumber(phonenumber);

        setInfo(ID, Age, Address, Phonenumber);
    }

    public void getID(int ID) {
        this.ID = ID;
    }

    public void getAge(String age) {
        this.Age = age;
    }

    public void getAddress(String address) {
        this.Address = address;
    }

    public void getPhonenumber(String phonenumber) {
        this.Phonenumber = phonenumber;
    }

    public int setID() {
        return ID;
    }

    public String setAge() {
        return Age;
    }

    public String setAddress() {
        return Address;
    }

    public String setPhonenumber() {
        return Phonenumber;
    }

    public void setInfo(int ID, String age, String address, String phonenumber) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");

            // Create table if it doesn't exist
            String createTableSql = "CREATE TABLE IF NOT EXISTS user_info (" +
                    "info_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "age VARCHAR(255)," +
                    "address VARCHAR(255)," +
                    "phonenumber VARCHAR(255)," +
                    "user_id INT," +
                    "FOREIGN KEY (user_id) REFERENCES users(id)" +
                    ")";
            statement = connection.prepareStatement(createTableSql);
            statement.executeUpdate();
            System.out.println("user_info table created (if not existed)");

            // Check if data exists for the given user ID
            String checkDataSql = "SELECT COUNT(*) FROM user_info WHERE user_id=?";
            statement = connection.prepareStatement(checkDataSql);
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                // Update existing data
                String updateSql = "UPDATE user_info SET age=?, address=?, phonenumber=? WHERE user_id=?";
                statement = connection.prepareStatement(updateSql);
                statement.setString(1, age);
                statement.setString(2, address);
                statement.setString(3, phonenumber);
                statement.setInt(4, ID);
                statement.executeUpdate();
                System.out.println("Data updated in the user_info table!");
            } else {
                // Insert new data
                String insertSql = "INSERT INTO user_info (age, address, phonenumber, user_id) VALUES (?, ?, ?, ?)";
                statement = connection.prepareStatement(insertSql);
                statement.setString(1, age);
                statement.setString(2, address);
                statement.setString(3, phonenumber);
                statement.setInt(4, ID);
                statement.executeUpdate();
                System.out.println("Data inserted into the user_info table!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection");
                e.printStackTrace();
            }
        }
    }
}
