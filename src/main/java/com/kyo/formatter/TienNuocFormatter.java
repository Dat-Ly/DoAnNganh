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
public class TienNuocFormatter implements Formatter<Bill>{

    @Override
    public String print(Bill tn, Locale locale) {
        return String.valueOf(tn.getTienNuoc());
    }

    @Override
    public Bill parse(String tiennuoc, Locale locale) throws ParseException {
        Bill b = new Bill();
        b.setTienNuoc(Long.parseLong(tiennuoc));
        return b;
    }
    
}
