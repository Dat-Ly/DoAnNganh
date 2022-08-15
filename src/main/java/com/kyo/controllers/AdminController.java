/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.controllers;

import com.kyo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Kyoya
 */
@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/admin")
    @Transactional
    public String admin (Model model) {
        model.addAttribute("users",this.userRepository.getUsers());
        return "admin";
    }
}
