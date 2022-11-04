/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author datly
 */
@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findByIdBill", query = "SELECT b FROM Bill b WHERE b.idBill = :idBill"),
    @NamedQuery(name = "Bill.findByTotal", query = "SELECT b FROM Bill b WHERE b.total = :total"),
    @NamedQuery(name = "Bill.findByCreateDate", query = "SELECT b FROM Bill b WHERE b.createDate = :createDate"),
    @NamedQuery(name = "Bill.findByTienNuoc", query = "SELECT b FROM Bill b WHERE b.tienNuoc = :tienNuoc"),
    @NamedQuery(name = "Bill.findByTienDien", query = "SELECT b FROM Bill b WHERE b.tienDien = :tienDien"),
    @NamedQuery(name = "Bill.findByTienPhong", query = "SELECT b FROM Bill b WHERE b.tienPhong = :tienPhong")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBill")
    private Integer idBill;
    @Basic(optional = false)
    @NotNull(message="{bill.total.errNull}")
    @Column(name = "total")
    private long total;
    @Basic(optional = false)
   
    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @NotNull(message="{bill.tienNuoc.errNull}")
    @Column(name = "tienNuoc")
    private long tienNuoc;
    @Basic(optional = false)
    @NotNull(message="{bill.tienDien.errNull}")
    @Column(name = "tienDien")
    private long tienDien;
    @Basic(optional = false)
    @NotNull(message = "1")
    @Column(name = "tienPhong")
    private long tienPhong;
    @JoinColumn(name = "idCustomer", referencedColumnName = "idCustomer")
    @ManyToOne(optional = false)
    private Customer idCustomer;
    @JoinColumn(name = "idRoom", referencedColumnName = "idRoom")
    @ManyToOne(optional = false)
    private Room idRoom;

    public Bill() {
    }

    public Bill(Integer idBill) {
        this.idBill = idBill;
    }

    public Bill(Integer idBill, long total, Date createDate, long tienNuoc, long tienDien, long tienPhong) {
        this.idBill = idBill;
        this.total = total;
        this.createDate = createDate;
        this.tienNuoc = tienNuoc;
        this.tienDien = tienDien;
        this.tienPhong = tienPhong;
    }

    public Integer getIdBill() {
        return idBill;
    }

    public void setIdBill(Integer idBill) {
        this.idBill = idBill;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getTienNuoc() {
        return tienNuoc;
    }

    public void setTienNuoc(long tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    public long getTienDien() {
        return tienDien;
    }

    public void setTienDien(long tienDien) {
        this.tienDien = tienDien;
    }

    public long getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(long tienPhong) {
        this.tienPhong = tienPhong;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBill != null ? idBill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.idBill == null && other.idBill != null) || (this.idBill != null && !this.idBill.equals(other.idBill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.Bill[ idBill=" + idBill + " ]";
    }
    
}
