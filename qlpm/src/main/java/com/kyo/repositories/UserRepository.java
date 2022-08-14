/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.repositories;

import com.kyo.pojos.Users;
import java.util.List;

/**
 *
 * @author datly
 */
public interface UserRepository {
    boolean addUser(Users user);
    List<Users>getUsers(String username);
}
