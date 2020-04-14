package model;

public class Customer {
    private int id;
    private String name;
    private String email;
    private String address;
    private int country_id;
    private String country_name;

    public Customer() {
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, String name, String email, String address, String country_name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.country_name = country_name;
    }

    public Customer(String name, String email, String address, int country_id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.country_id = country_id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
