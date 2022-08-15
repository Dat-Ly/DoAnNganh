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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kyoya
 */
@Entity
@Table(name = "lich_kham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LichKham.findAll", query = "SELECT l FROM LichKham l"),
    @NamedQuery(name = "LichKham.findByIdLichkham", query = "SELECT l FROM LichKham l WHERE l.idLichkham = :idLichkham"),
    @NamedQuery(name = "LichKham.findByTendangky", query = "SELECT l FROM LichKham l WHERE l.tendangky = :tendangky"),
    @NamedQuery(name = "LichKham.findByNgayKham", query = "SELECT l FROM LichKham l WHERE l.ngayKham = :ngayKham")})
public class LichKham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_lichkham")
    private Integer idLichkham;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Ten_dang_ky")
    private String tendangky;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_kham")
    @Temporal(TemporalType.DATE)
    private Date ngayKham;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private Users idUser;

    public LichKham() {
    }

    public LichKham(Integer idLichkham) {
        this.idLichkham = idLichkham;
    }

    public LichKham(Integer idLichkham, String tendangky, Date ngayKham) {
        this.idLichkham = idLichkham;
        this.tendangky = tendangky;
        this.ngayKham = ngayKham;
    }

    public Integer getIdLichkham() {
        return idLichkham;
    }

    public void setIdLichkham(Integer idLichkham) {
        this.idLichkham = idLichkham;
    }

    public String getTendangky() {
        return tendangky;
    }

    public void setTendangky(String tendangky) {
        this.tendangky = tendangky;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLichkham != null ? idLichkham.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LichKham)) {
            return false;
        }
        LichKham other = (LichKham) object;
        if ((this.idLichkham == null && other.idLichkham != null) || (this.idLichkham != null && !this.idLichkham.equals(other.idLichkham))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.LichKham[ idLichkham=" + idLichkham + " ]";
    }
    
}
