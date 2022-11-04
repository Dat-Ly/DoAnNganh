/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.formatter;

import com.kyo.pojos.Room;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author datly
 */
public class RoomFormatter implements Formatter<Room> {

    @Override
    public String print(Room t, Locale locale) {
        return String.valueOf(t.getIdRoom());
    }

    @Override
    public Room parse(String rID, Locale locale) throws ParseException {
        Room r = new Room();
        r.setIdRoom(Integer.parseInt(rID));
        return r;
    }
    
}
