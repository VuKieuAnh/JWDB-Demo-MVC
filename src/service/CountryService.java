package service;

import model.Country;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CountryService {
    public List<Country> findAll();

    public void save(Country customer) throws SQLException;

    public Country findById(int id);

    public boolean update(int id, Country customer) throws SQLException;

    public boolean remove(int id) throws SQLException;

}
