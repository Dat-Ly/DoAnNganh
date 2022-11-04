/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author datly
 */
@Entity
@Table(name = "room")
@CascadeOnDelete
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByIdRoom", query = "SELECT r FROM Room r WHERE r.idRoom = :idRoom"),
    @NamedQuery(name = "Room.findByRoomName", query = "SELECT r FROM Room r WHERE r.roomName = :roomName"),
    @NamedQuery(name = "Room.findByCost", query = "SELECT r FROM Room r WHERE r.cost = :cost"),
    @NamedQuery(name = "Room.findByAvatar", query = "SELECT r FROM Room r WHERE r.avatar = :avatar"),
    @NamedQuery(name = "Room.findBySoluong", query = "SELECT r FROM Room r WHERE r.soluong = :soluong"),
    @NamedQuery(name = "Room.findByTrangthai", query = "SELECT r FROM Room r WHERE r.trangthai = :trangthai")})
public class Room implements Serializable {

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    public static final String CONPHONG="PHÒNG TRỐNG";
    public static final String HETPHONG="ĐÃ THUÊ";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoom")
    private Integer idRoom;
    @Basic(optional = false)
    @NotNull(message = "{room.roomName.NotNull}" )
    @Size(min = 3, max = 100, message = "{room.name.lenErr}")
    @Column(name = "roomName")
    private String roomName;
    @Basic(optional = false)
    @NotNull(message = "{room.cost.nullErr}")
    @Column(name = "cost")
    private long cost;
    @Basic(optional = false)
    @NotNull(message = "{room.avatar.nullErr}")
    @Size(min = 1, max = 100)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "soluong")
    private Integer soluong;
    @Size(max = 45)
    @Column(name = "trangthai")
    private String trangthai;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idRoom",orphanRemoval = true)
    private Collection<Bill> billCollection;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "idRoom",orphanRemoval = true)
    private Collection<Customer> customerCollection;
    @Transient
    private MultipartFile file;

    public Room() {
    }

    public Room(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Room(Integer idRoom, String roomName, long cost, String avatar) {
        this.idRoom = idRoom;
        this.roomName = roomName;
        this.cost = cost;
        this.avatar = avatar;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kyo.pojos.Room[ idRoom=" + idRoom + " ]";
    }
    
}
