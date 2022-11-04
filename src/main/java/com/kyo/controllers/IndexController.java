/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.controllers;



import com.cloudinary.Cloudinary;
import com.kyo.pojos.Room;
import com.kyo.services.CustomerSevice;
import com.kyo.services.RoomService;
import java.util.Map;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
 * @author Kyoya
 */
@Controller
public class IndexController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerSevice customerSevice;
    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping("/")
    public String showRoom(Model model,@RequestParam(required = false)Map<String, String>params) {
        int page=Integer.parseInt(params.getOrDefault("page", "1")) ;
        model.addAttribute("rooms", this.roomService.getRooms(params.get("kw"),page));
        model.addAttribute("counter", this.roomService.countRoom());
        return "index";
    }
    @GetMapping("/addroom")
    public String addRoomView(Model model) {
        model.addAttribute("rooms", new Room());
        return "addroom";
    }
    @PostMapping("/addroom")
    public String addRoom(Model model,@ModelAttribute(value = "rooms")@Valid Room room,BindingResult result){
        if(!result.hasErrors()){
            this.roomService.addRooms(room);
            return "redirect:/";
        }   
        return "addroom";
    }
    @RequestMapping("/delete/{roomId}")
    public String delete(Model model, @PathVariable(value = "roomId") int roomId) {
        if (this.roomService.deleteRoom(roomId) == true) {
            return "redirect:/";
        }
        return "redirect:/";
    }
    @RequestMapping("/upd/{idRoom}")
    public String update(Model model, @PathVariable(value = "idRoom") int idRoom){
        Room room = this.roomService.getRoomById(idRoom);
        model.addAttribute("roomud", room);
        return "updateroom";
    }
    @PostMapping("/upd/{idRoom}")
    public String updRoom(Model model,
            @ModelAttribute(value="roomud")@Valid Room room,BindingResult result) {
       
        if(!result.hasErrors()){
            this.roomService.updateRoom(room);
            return "redirect:/";
        }
             
        return "redirect:/";
    }
    @GetMapping("/room")
    public String roomView(Model model,@RequestParam(value = "tm",required = false, defaultValue = "") String tm){
        model.addAttribute("roomlist", this.roomService.getRoom(tm));
        return "room";
    }
}
