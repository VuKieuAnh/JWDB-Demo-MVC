package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService{
    private String jdbcUrl= "jdbc:mysql://localhost:3308/democ12?useUnicode=true&characterEncoding=utf-8";
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
    @Override
    public void addAndUpdateTransaction() throws SQLException {
        Connection connection = getConnection();
        try (
                PreparedStatement statement1 = connection.prepareStatement("insert into  customer (name,email,address) value (?,?,?)");
                PreparedStatement statement2 = connection.prepareStatement("insert into  customer (name,email,address) value (?,?,?)");
                PreparedStatement statement3 = connection.prepareStatement("update customer set name = ?, email=?, address=? where id =?");
        ) {
            connection.setAutoCommit(false);
            statement1.setString(1,"Hien");
            statement1.setString(2,"hien@gmail.com");
            statement1.setString(3,"Viet Nam");
            statement1.executeUpdate();
            statement2.setString(1,"Loi");
            statement2.setString(2,"mail.com");
            statement2.setString(3,"Viet Nam");
            statement2.executeUpdate();
            statement3.setString(1,"linh tinh1");
            statement3.setString(2,"linh tinh1");
            statement3.setString(3,"linh tinh1");
            statement3.setInt(4,1);
            statement3.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {

// Rollback update

                connection.rollback();

                System.out.println("Successfully rolled back changes from the database!");

            } catch (SQLException e1) {

                System.out.println("Could not rollback updates " + e1.getMessage());

            }
        }

    }

}
