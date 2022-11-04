/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.services.imp;

import com.kyo.pojos.Customer;
import com.kyo.repositories.CustomerRepository;
import com.kyo.services.CustomerSevice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author datly
 */
@Service
public class CustomerSerImp implements CustomerSevice{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomer(String kw) {
        return this.customerRepository.getCustomer(kw);
    }

    @Override
    public boolean addCustomer(Customer cus) {
        return this.customerRepository.addCustomer(cus);
    }

    @Override
    public List<Customer> getListCus() {
        return this.customerRepository.getListCus();
    }

    @Override
    public Customer getCusById(int cusid) {
        return this.customerRepository.getCusById(cusid);
    }

    @Override
    public boolean deleteCus(int id) {
        return this.customerRepository.deleteCus(id);
    }

    @Override
    public boolean updateCus( Customer cusnew) {
        return this.customerRepository.updateCus( cusnew);
    }
}
