/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kyo.services;

import com.kyo.pojos.Bill;
import com.kyo.pojos.Customer;
import com.kyo.pojos.Room;
import java.util.List;


/**
 *
 * @author datly
 */
public interface BillService {
     boolean addBill(Bill bill);
      Bill getBillById(int idBill);
      List<Bill>getListBill();
}
