/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kyoya
 */
@Entity
@Table(name = "thuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thuoc.findAll", query = "SELECT t FROM Thuoc t"),
    @NamedQuery(name = "Thuoc.findByIdThuoc", query = "SELECT t FROM Thuoc t WHERE t.idThuoc = :idThuoc"),
    @NamedQuery(name = "Thuoc.findByTenthuoc", query = "SELECT t FROM Thuoc t WHERE t.tenthuoc = :tenthuoc"),
    @NamedQuery(name = "Thuoc.findByTien", query = "SELECT t FROM Thuoc t WHERE t.tien = :tien")})
public class Thuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_thuoc")
    private Integer idThuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ten_thuoc")
    private String tenthuoc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tien")
    private BigDecimal tien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idThuoc")
    private Set<Chitiettoathuoc> chitiettoathuocSet;

    public Thuoc() {
    }

    public Thuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public Thuoc(Integer idThuoc, String tenthuoc, BigDecimal tien) {
        this.idThuoc = idThuoc;
        this.tenthuoc = tenthuoc;
        this.tien = tien;
    }

    public Integer getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Integer idThuoc) {
        this.idThuoc = idThuoc;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public BigDecimal getTien() {
        return tien;
    }

    public void setTien(BigDecimal tien) {
        this.tien = tien;
    }

    @XmlTransient
    public Set<Chitiettoathuoc> getChitiettoathuocSet() {
        return chitiettoathuocSet;
    }

    public void setChitiettoathuocSet(Set<Chitiettoathuoc> chitiettoathuocSet) {
        this.chitiettoathuocSet = chitiettoathuocSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idThuoc != null ? idThuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thuoc)) {
            return false;
        }
        Thuoc other = (Thuoc) object;
        if ((this.idThuoc == null && other.idThuoc != null) || (this.idThuoc != null && !this.idThuoc.equals(other.idThuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.Thuoc[ idThuoc=" + idThuoc + " ]";
    }
    
}
