/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.services;

import com.kyo.pojos.Customer;
import java.util.List;

/**
 *
 * @author datly
 */
public interface CustomerSevice {
    List<Customer> getCustomer(String kw);
    boolean addCustomer(Customer cus);
    List<Customer>getListCus();
    Customer getCusById(int cusid);
    boolean deleteCus(int id);
    boolean updateCus( Customer cusnew);
}
