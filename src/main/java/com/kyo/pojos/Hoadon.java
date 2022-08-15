/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kyoya
 */
@Entity
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByIdHoadon", query = "SELECT h FROM Hoadon h WHERE h.idHoadon = :idHoadon"),
    @NamedQuery(name = "Hoadon.findByThanhtien", query = "SELECT h FROM Hoadon h WHERE h.thanhtien = :thanhtien")})
public class Hoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hoadon")
    private Integer idHoadon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Thanhtien")
    private BigDecimal thanhtien;
    @JoinColumn(name = "id_chitiettoathuoc", referencedColumnName = "id_chitiettoathuoc")
    @ManyToOne(optional = false)
    private Chitiettoathuoc idChitiettoathuoc;

    public Hoadon() {
    }

    public Hoadon(Integer idHoadon) {
        this.idHoadon = idHoadon;
    }

    public Hoadon(Integer idHoadon, BigDecimal thanhtien) {
        this.idHoadon = idHoadon;
        this.thanhtien = thanhtien;
    }

    public Integer getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(Integer idHoadon) {
        this.idHoadon = idHoadon;
    }

    public BigDecimal getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(BigDecimal thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Chitiettoathuoc getIdChitiettoathuoc() {
        return idChitiettoathuoc;
    }

    public void setIdChitiettoathuoc(Chitiettoathuoc idChitiettoathuoc) {
        this.idChitiettoathuoc = idChitiettoathuoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoadon != null ? idHoadon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.idHoadon == null && other.idHoadon != null) || (this.idHoadon != null && !this.idHoadon.equals(other.idHoadon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.Hoadon[ idHoadon=" + idHoadon + " ]";
    }
    
}
