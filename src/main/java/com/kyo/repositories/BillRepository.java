/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kyo.repositories;

import com.kyo.pojos.Bill;
import java.util.List;


/**
 *
 * @author datly
 */
public interface BillRepository {
    boolean addBill(Bill bill);
    Bill getBillById(int idBill);
    List<Bill>getListBill();
    
}
