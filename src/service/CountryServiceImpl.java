package service;

import model.Country;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryServiceImpl implements CountryService{
    private String jdbcUrl= "jdbc:mysql://localhost:3308/democ12?useUnicode=true&characterEncoding=utf-8";
    private String userSql = "root";
    private String passSql = "123456";
    private String GETALLCOUNTRY = "select * from country";

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
    public List<Country> findAll() {
        List<Country> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GETALLCOUNTRY);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Country country = new Country(id, name);
                list.add(country);
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    @Override
    public void save(Country customer) throws SQLException {

    }

    @Override
    public Country findById(int id) {
        return null;
    }

    @Override
    public boolean update(int id, Country customer) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return false;
    }


}
