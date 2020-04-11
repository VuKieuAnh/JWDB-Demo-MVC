package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private String jdbcUrl= "jdbc:mysql://localhost:3308/democ12";
    private String userSql = "root";
    private String passSql = "123456";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, userSql, passSql);
        } catch (SQLException e) {
            System.out.println("KHông kết nối");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String ad = resultSet.getString(4);
                Customer customer = new Customer(id, name, email, ad);
                list.add(customer);
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void save(Customer customer) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into customer (name, email, address) value (?, ?, ?)")){
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getAddress());
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return false;
    }
}
