/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.services.imp;

import com.kyo.repositories.ThongKeRepo;
import com.kyo.services.ThongKeService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author datly
 */
@Service
public class ThongKeServiceImp implements ThongKeService{
    @Autowired
    private ThongKeRepo thongKeRepo;

    @Override
    public List<Object[]> MonthStats() {
        return this.thongKeRepo.MonthStats();
    }
    
}
