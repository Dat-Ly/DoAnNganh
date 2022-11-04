
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.services.imp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kyo.pojos.Room;
import com.kyo.repositories.RoomRepository;
import com.kyo.services.RoomService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author datly
 */
@Service
public class RoomServiceImp implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Room> getRooms(String kw, int page) {
       return this.roomRepository.getRooms(kw,page);
    }

    @Override
    public boolean addRooms(Room room) {
        try {
            Map r = this.cloudinary.uploader().upload(room.getFile().getBytes(), ObjectUtils.asMap("resoure_type", "auto"));
            room.setAvatar((String) r.get("secure_url"));
            if(room.getTrangthai()==null)
                room.setTrangthai(Room.CONPHONG);
            if (room.getSoluong()==null)
                room.setSoluong(1);
            
            
            return this.roomRepository.addRooms(room);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public long countRoom() {
        return this.roomRepository.countRoom();
    }

    @Override
    public List<Room> getListRoom() {
           return this.roomRepository.getListRoom();
    }

    @Override
    public boolean deleteRoom(int id) {
        return this.roomRepository.deleteRoom(id);
    }

    @Override
    public boolean updateRoom(Room roomnew) {
        try {

            Map r = this.cloudinary.uploader().upload(roomnew.getFile().getBytes(), ObjectUtils.asMap("resoure_type", "auto"));
            roomnew.setAvatar((String) r.get("secure_url"));
            return this.roomRepository.updateRoom(roomnew);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public Room getRoomById(int roomid) {
        return this.roomRepository.getRoomById(roomid);
    }

    @Override
    public List<Room> getRoom(String tm) {
        return this.roomRepository.getRoom(tm);
    }

    @Override
    public boolean updateTinhTrang(Room r) {
        return this.roomRepository.updateTinhTrang(r);
    }

    @Override
    public boolean updTinhTrang(Room r) {
        return this.roomRepository.updTinhTrang(r);
    }
    
}
