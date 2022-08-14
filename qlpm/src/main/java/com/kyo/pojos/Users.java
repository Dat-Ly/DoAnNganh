/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author datly
 */
@Entity
@Table(name= "users")
public class Users implements Serializable {
    private static String ADMIN="ROLE_ADMIN";
    private static String USER="ROLE_USER";
    private static String BACSI="ROLE_BACSI";
    private static String YTA="ROLE_YTA";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_users;
    private String hoTen;
    private int tuoi;
    private String chucVu;
    private String username;
    private String password;
    private String email;
    private String avartar;

    /**
     * @return the id_users
     */
    public int getId_users() {
        return id_users;
    }

    /**
     * @param id_users the id_users to set
     */
    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the tuoi
     */
    public int getTuoi() {
        return tuoi;
    }

    /**
     * @param tuoi the tuoi to set
     */
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    /**
     * @return the chucVu
     */
    public String getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the avartar
     */
    public String getAvartar() {
        return avartar;
    }

    /**
     * @param avartar the avartar to set
     */
    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

   
    
}
