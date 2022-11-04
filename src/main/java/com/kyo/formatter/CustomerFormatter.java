/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.formatter;

import com.kyo.pojos.Customer;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author datly
 */
public class CustomerFormatter implements Formatter<Customer>{

    @Override
    public String print(Customer c, Locale locale) {
        return String.valueOf(c.getIdCustomer());
    }

    @Override
    public Customer parse(String cID, Locale locale) throws ParseException {
        Customer cus=new Customer();
        cus.setIdCustomer(Integer.parseInt(cID));
        return cus;
    }
    
}
