package com.CustomerRelationshipManagement.dao;

import com.CustomerRelationshipManagement.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    SessionFactory sf;

    public CustomerDao(SessionFactory sf) {
       super();
        this.sf = sf;
    }

    public String insertCustomer(Customer customer){

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.save(customer);
        tr.commit();
        session.close();

        return "Customer Insert Successfully!!!";
    }

    public List<Customer> getCustomersList(){
        Session session = sf.openSession();
        return session.createQuery("from Customer").list();

    }

    public Customer getCustomerById(int id){
        Session session = sf.openSession();
        Customer customer=session.get(Customer.class, id);
        return customer;
    }

    public String updateCustomer(int id, Customer customer){

        Session session = sf.openSession();
        Transaction tr =  session.beginTransaction();
        Customer cust = session.get(Customer.class, id);
        tr.commit();
        session.close();

        return "Customer Updates Successfully";
    }


    public String deleteCustomerById(int id){
        Session session= sf.openSession();
        Transaction tr = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        tr.commit();
        session.close();

        return "Customer Deleted Successfully";
    }

    public String insertMultipleCustomers(List<Customer> customers){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        for (Customer customer : customers){
            session.save(customer);
        }
        tr.commit();
        session.close();

        return "Customers inserted Successfully";
    }

    public List<Customer> getCustomerByFirstName(String firstName){
        Session session = sf.openSession();
        Query<Customer> customers = session.createQuery("from Customer c where c.firstName=:firstName", Customer.class);
        customers.setParameter("firstName", firstName);
        List<Customer> list = customers.list();
        return list;
    }

    public List<Customer> getCustomerByLastName(String lastName){
        Session session = sf.openSession();
        Query<Customer> customers= session.createQuery("from Customer c where c.lastName=:lastName", Customer.class);
        customers.setParameter("lastName", lastName);
        List<Customer> list = customers.list();
        return list;
    }

    public String updateFirstName(int id, String firstName){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        tr.commit();
        session.close();

        return "updates successfully";
    }

    public String updateLastName(int id, String lastName){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        tr.commit();
        session.close();

        return "LastName updates successfully";
    }
}


