/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kyo.repositories;

import com.kyo.pojos.Users;
import java.util.List;

/**
 *
 * @author Kyoya
 */
public interface UserRepository {
    List<Users> getUsers();
}
