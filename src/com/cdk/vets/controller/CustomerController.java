package com.cdk.vets.controller;

import com.cdk.vets.model.Customer;
import com.cdk.vets.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        int value = customerService.add(customer);
        return customer;
    }

    @RequestMapping(value = "/updateCustomer",consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        int value = customerService.modify(customer);
        return customer;
    }


    @RequestMapping(value = "/deleteCustomer/{id}",produces = MediaType.TEXT_PLAIN_VALUE ,method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable int id){
        customerService.remove(id);
        return "Customer with " + id +" deleted successfully!";
    }

    @RequestMapping(value = "/customers",produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Customer> readAllCustomersAsJSON(){
        return customerService.readAll();
    }

    @RequestMapping(value = "/customers",produces = MediaType.APPLICATION_XML_VALUE ,method = RequestMethod.GET)
    public Collection<Customer> readAllCustomersAsXML(){
        return customerService.readAll();
    }


    @RequestMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_XML_VALUE ,method = RequestMethod.GET)
    public Customer readCusomerByIdAsXML(@PathVariable Integer id){
        return customerService.readByVin(id);
    }

    @RequestMapping(value = "/customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Customer readCusomerByIdAsJSON(@PathVariable Integer id){
        return customerService.readByVin(id);
    }


}
