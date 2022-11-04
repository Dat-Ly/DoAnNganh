/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.formatter;

import com.kyo.pojos.Bill;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author datly
 */
public class TongTienFormatter implements Formatter<Bill>{

    @Override
    public String print(Bill tt, Locale locale) {
        return String.valueOf(tt.getTotal());
    }

    @Override
    public Bill parse(String total, Locale locale) throws ParseException {
        Bill b = new Bill();
        b.setTotal(Long.parseLong(total));
        return b;
    }
    
}
