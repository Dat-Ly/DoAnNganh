/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.services.imp;

import com.kyo.pojos.Bill;
import com.kyo.pojos.Customer;
import com.kyo.pojos.Room;
import com.kyo.repositories.BillRepository;
import com.kyo.repositories.CustomerRepository;
import com.kyo.repositories.RoomRepository;
import com.kyo.services.BillService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.CustomizerRegistry;
import org.springframework.stereotype.Service;

/**
 *
 * @author datly
 */
@Service
public class BillServiceImp implements BillService{
    @Autowired
    private BillRepository billRepository;

    @Override
    public boolean addBill(Bill bill) {
        if(bill.getIdBill()==null)
            bill.setIdBill(1);
        bill.setCreateDate(new Date());
        return this.billRepository.addBill(bill);
    }

    @Override
    public Bill getBillById(int idBill) {
        return this.billRepository.getBillById(idBill);
    }

    @Override
    public List<Bill> getListBill() {
        return this.billRepository.getListBill();
    }
    
}
