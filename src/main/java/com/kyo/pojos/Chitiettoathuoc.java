/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kyoya
 */
@Entity
@Table(name = "chitiettoathuoc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiettoathuoc.findAll", query = "SELECT c FROM Chitiettoathuoc c"),
    @NamedQuery(name = "Chitiettoathuoc.findByIdChitiettoathuoc", query = "SELECT c FROM Chitiettoathuoc c WHERE c.idChitiettoathuoc = :idChitiettoathuoc"),
    @NamedQuery(name = "Chitiettoathuoc.findByNgayTaoToathuoc", query = "SELECT c FROM Chitiettoathuoc c WHERE c.ngayTaoToathuoc = :ngayTaoToathuoc"),
    @NamedQuery(name = "Chitiettoathuoc.findBySoluong", query = "SELECT c FROM Chitiettoathuoc c WHERE c.soluong = :soluong")})
public class Chitiettoathuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_chitiettoathuoc")
    private Integer idChitiettoathuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_tao_toathuoc")
    @Temporal(TemporalType.DATE)
    private Date ngayTaoToathuoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "So_luong")
    private int soluong;
    @Lob
    @Size(max = 65535)
    @Column(name = "Nhanxet")
    private String nhanxet;
    @JoinColumn(name = "id_thuoc", referencedColumnName = "id_thuoc")
    @ManyToOne(optional = false)
    private Thuoc idThuoc;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Users idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idChitiettoathuoc")
    private Set<Hoadon> hoadonSet;

    public Chitiettoathuoc() {
    }

    public Chitiettoathuoc(Integer idChitiettoathuoc) {
        this.idChitiettoathuoc = idChitiettoathuoc;
    }

    public Chitiettoathuoc(Integer idChitiettoathuoc, Date ngayTaoToathuoc, int soluong) {
        this.idChitiettoathuoc = idChitiettoathuoc;
        this.ngayTaoToathuoc = ngayTaoToathuoc;
        this.soluong = soluong;
    }

    public Integer getIdChitiettoathuoc() {
        return idChitiettoathuoc;
    }

    public void setIdChitiettoathuoc(Integer idChitiettoathuoc) {
        this.idChitiettoathuoc = idChitiettoathuoc;
    }

    public Date getNgayTaoToathuoc() {
        return ngayTaoToathuoc;
    }

    public void setNgayTaoToathuoc(Date ngayTaoToathuoc) {
        this.ngayTaoToathuoc = ngayTaoToathuoc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNhanxet() {
        return nhanxet;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }

    public Thuoc getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Thuoc idThuoc) {
        this.idThuoc = idThuoc;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Set<Hoadon> getHoadonSet() {
        return hoadonSet;
    }

    public void setHoadonSet(Set<Hoadon> hoadonSet) {
        this.hoadonSet = hoadonSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChitiettoathuoc != null ? idChitiettoathuoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiettoathuoc)) {
            return false;
        }
        Chitiettoathuoc other = (Chitiettoathuoc) object;
        if ((this.idChitiettoathuoc == null && other.idChitiettoathuoc != null) || (this.idChitiettoathuoc != null && !this.idChitiettoathuoc.equals(other.idChitiettoathuoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.Chitiettoathuoc[ idChitiettoathuoc=" + idChitiettoathuoc + " ]";
    }
    
}
