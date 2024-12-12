package com.CustomerRelationshipManagement.controller;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer){
        String msg = customerService.insertCustomer(customer);
        return msg;
    }

    @GetMapping("/get")
    public List<Customer> getCustomersList(){
        List<Customer> list = customerService.getCustomerList();
        return list;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("/update/{id}")
    public String updateCustomer(@PathVariable int id,@RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }

    @PostMapping
    public String insertMultipleCustomers(@RequestBody List<Customer> customers){
        return customerService.insertMultipleCustomers(customers);
    }

    @GetMapping("/byName/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName){
        return customerService.getCustomerByFirstName(firstName);
    }


    @GetMapping("/byLastName/{lastName}")
    public List<Customer> getCustomerByLastName(@PathVariable String lastName){
        return customerService.getCustomerByLastName(lastName);
    }

    @PutMapping("/{id}")
    public String updateFirstName(@PathVariable int id,@RequestBody Map<String, String> request){
        String firstName = request.get("firstName");
        return customerService.updateFirstName(id, firstName);
    }

    @PutMapping("/lastName/{id}")
    public String updateLastName(@PathVariable int id, @RequestBody Map<String, String> request){
        String lastName = request.get("lastName");
        return customerService.updateLastName(id, lastName);
    }
}
