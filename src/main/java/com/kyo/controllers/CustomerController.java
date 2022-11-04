/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.controllers;

import com.kyo.pojos.Customer;
import com.kyo.pojos.Room;
import com.kyo.services.CustomerSevice;
import com.kyo.services.RoomService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author datly
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerSevice customerSevice;
    @Autowired
    private RoomService roomService;
    @ModelAttribute
    public void commonAttrs(Model model){
        model.addAttribute("room", this.roomService.getListRoom());

    }
    @RequestMapping("/customer")
    public String cusList(Model model,@RequestParam(value = "kw",required = false, defaultValue = "") String kw){
        model.addAttribute("customers", this.customerSevice.getCustomer(kw));
        return "customer"; 
    
    }
    @PostMapping("/addcustomer/{idRoom}")
    public String thuePhong(Model model,@ModelAttribute(value="cus")@Valid Customer cus, BindingResult result,@PathVariable(value="idRoom") int roomId ){
        Room room = this.roomService.getRoomById(roomId);
        if(!result.hasErrors()){
            this.customerSevice.addCustomer(cus);
            this.roomService.updateTinhTrang(room);
            return "redirect:/customer";
        }
        return"addcustomer";
    }
    @GetMapping("/addcustomer/{idRoom}")
    public String thuePhongView(Model model,@PathVariable(value="idRoom") int roomId ){
        model.addAttribute("cus", new Customer());
        return"addcustomer";
    }
    @RequestMapping("/del/{cusId}/{idRoom}")
    public String delete(Model model, @PathVariable(value = "cusId") int cusId,@PathVariable(value="idRoom") int roomId) {
           Room room = this.roomService.getRoomById(roomId);
        if (this.customerSevice.deleteCus(cusId) == true) {
                this.roomService.updTinhTrang(room);
            return "redirect:/customer";
        }
        return "redirect:/";
    }
    @RequestMapping("/update/{idCustomer}")
    public String update(Model model, @PathVariable(value = "idCustomer") int idCustomer){
        Customer cus = this.customerSevice.getCusById(idCustomer);
        model.addAttribute("cusud", cus);
        return "updatecus";
    }
       @PostMapping("/update/{idCustomer}")
    public String updCus(Model model,
            @ModelAttribute(value="cusud")@Valid Customer cus, BindingResult result) {
        
        if(!result.hasErrors()){
            this.customerSevice.updateCus(cus);
            return "redirect:/customer"; 
        }
        return "redirect:/customer";
    }

}
