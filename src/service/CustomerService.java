package service;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();

    public void save(Customer customer) throws SQLException;

    public Customer findById(int id);

    public boolean update(int id, Customer customer) throws SQLException;

    public boolean remove(int id) throws SQLException;

    public void addAndUpdateTransaction() throws SQLException;
    public List<Customer> findByCountryID(int country_id);
}
