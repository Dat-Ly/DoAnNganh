/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.controllers;

import com.kyo.services.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author datly
 */
@Controller
public class ThongKeController {
    @Autowired
    private ThongKeService thongKeService;
    @GetMapping("/thongke")
    public String thongke(Model model){
        model.addAttribute("thongke", this.thongKeService.MonthStats());
        return "thongke";
    }
}
