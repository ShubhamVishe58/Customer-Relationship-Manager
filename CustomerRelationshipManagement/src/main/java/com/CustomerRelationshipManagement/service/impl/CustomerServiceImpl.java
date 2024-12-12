package com.CustomerRelationshipManagement.service.impl;


import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public String insertCustomer(Customer customer) {

        String msg = customerDao.insertCustomer(customer);

        return msg;
    }

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> list = customerDao.getCustomersList();
        return list;
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public String updateCustomer(int id, Customer customer) {
        String msg =  customerDao.updateCustomer(id, customer);
        return msg;
    }

    @Override
    public String deleteCustomerById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public String insertMultipleCustomers(List<Customer> customers) {
        return customerDao.insertMultipleCustomers(customers);
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerDao.getCustomerByFirstName(firstName);
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) {
        return customerDao.getCustomerByLastName(lastName);
    }

    @Override
    public String updateFirstName(int id, String firstName) {
        return customerDao.updateFirstName(id, firstName);
    }

    @Override
    public String updateLastName(int id, String lastName) {
        return customerDao.updateLastName(id, lastName);
    }
}
