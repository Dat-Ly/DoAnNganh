/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kyo.services;

import com.kyo.pojos.Room;
import java.util.List;

/**
 *
 * @author datly
 */
public interface RoomService {
    List<Room>getRooms(String kw, int page);
    boolean addRooms(Room room);
    long countRoom();
    List<Room>getListRoom();
    boolean deleteRoom(int id);
    boolean updateRoom(Room roomnew);
    Room getRoomById(int roomid);
    List<Room>getRoom(String tm);
    boolean updateTinhTrang(Room r);
    boolean updTinhTrang(Room r);
}
