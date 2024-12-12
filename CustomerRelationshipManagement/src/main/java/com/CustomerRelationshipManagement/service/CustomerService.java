package com.CustomerRelationshipManagement.service;

import com.CustomerRelationshipManagement.entity.Customer;

import java.util.List;

public interface CustomerService {

    public String insertCustomer(Customer customer);

    public List<Customer> getCustomerList();

    public Customer getCustomerById(int id);

    public String updateCustomer(int id, Customer customer);

    public String deleteCustomerById(int id);

    public String insertMultipleCustomers(List<Customer> customers);

    public List<Customer> getCustomerByFirstName(String firstName);

    public List<Customer> getCustomerByLastName(String lastName);

    public String updateFirstName(int id, String firstName);

    public String updateLastName(int id, String lastName);
}
