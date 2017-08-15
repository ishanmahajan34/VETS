package com.cdk.vets.service;

import com.cdk.vets.dao.CustomerDAO;
import com.cdk.vets.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Transactional
    public int add(Customer customer) {
        //20 loc
        return customerDAO.save(customer);
    }

    @Transactional
    public int modify(Customer customer) {
        return customerDAO.update(customer);
    }


    @Transactional
    public Customer readByVin(Integer id) {
        return customerDAO.selectById(id);
    }

    @Transactional
    public List<Customer> readAll() {
        return customerDAO.selectAll();

    }

    @Transactional
    public void remove(int vin) {
        customerDAO.delete(vin);
    }

}
