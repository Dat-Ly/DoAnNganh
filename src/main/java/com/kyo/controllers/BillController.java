/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.controllers;

import com.kyo.pdf.PDFExport;
import com.kyo.pojos.Bill;
import com.kyo.pojos.Customer;
import com.kyo.pojos.Room;
import com.kyo.services.BillService;
import com.kyo.services.CustomerSevice;
import com.kyo.services.RoomService;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author datly
 */
@Controller
public class BillController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerSevice customerService;
    @Autowired
    private BillService billService;

    @GetMapping("/bill/{idCustomer}")
    public String billView(Model model,@PathVariable(value = "idCustomer") int cusId){
        model.addAttribute("cus", this.customerService.getCusById(cusId));
        model.addAttribute("bills", new Bill());
        return "bill";
    }
    @PostMapping("/bill/{idCustomer}/{idRoom}")
    public String addBill(Model model,@ModelAttribute(value="bills")@Valid Bill bill,BindingResult result,@PathVariable(value="idRoom") int roomId){
        Room room = this.roomService.getRoomById(roomId);
        if(!result.hasErrors()){
            this.billService.addBill(bill);
            this.roomService.updTinhTrang(room);
            return "redirect:/listbill";
        }
        return "bill";
    }
    @GetMapping("/bill/pdf/{idBill}")
    public void exportToPDF(HttpServletResponse response,@PathVariable(value="idBill")int idBill)throws DocumentException,IOException{
           
          response.setContentType("application/pdf");
          String headerKey="Content-Disposition";
          String headerValue="attachment;filename=bill.pdf";
          response.setHeader(headerKey, headerValue);
          Bill bill=billService.getBillById(idBill);
          PDFExport exporter=new PDFExport(bill);
          exporter.export(response);
          
    
    }
    @GetMapping("/listbill")
    public String listBill(Model model ){
        model.addAttribute("bill", this.billService.getListBill());
        return"listbill";
    }
}
