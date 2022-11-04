/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.repositories.imp;

import com.kyo.pojos.Customer;
import com.kyo.pojos.Room;
import com.kyo.repositories.RoomRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author datly
 */
@Repository
@Transactional
public class RoomRepositoryImp implements RoomRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Room> getRooms(String kw, int page) {
                Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Room> query = builder.createQuery(Room.class);
        Root root = query.from(Room.class);
        query=query.select(root);
        if( kw!=null){
            Predicate p = builder.like(root.get("roomName").as(String.class), String.format("%%%s%%", kw));
            query=query.where(p);
        }
        Query q =session.createQuery(query);
        int max =8;
        q.setMaxResults(max);
        q.setFirstResult((page-1)*max);
       
        return q.getResultList();
    }

    @Override
    public boolean addRooms(Room room) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(room);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public long countRoom() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query  q = session.createQuery("Select Count(*) From Room");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Room> getListRoom() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Room");
        return q.getResultList();
    }

    @Override
    public boolean deleteRoom(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        String hql = "delete from Room where idRoom.idRoom=:id";
        session.createQuery(hql).setParameter("id", id).executeUpdate();
        return true;
    }

    @Override
    public boolean updateRoom( Room roomnew) {
            Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            Room r = this.getRoomById(roomnew.getIdRoom());
            r.setRoomName(roomnew.getRoomName());
            r.setCost(roomnew.getCost());
            r.setAvatar(roomnew.getAvatar());
            r.setSoluong(roomnew.getSoluong());
            session.update(r);
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaUpdate<Room> update = builder.createCriteriaUpdate(Room.class);
//
//            Root root = update.from(Room.class);
//
//            update.set("roomName", roomnew.getRoomName());
//            update.set("cost", roomnew.getCost());
//            update.set("avatar", roomnew.getAvatar());
//            
//
//            update.where(builder.greaterThanOrEqualTo(root.get("roomName"), room.getRoomName()));
//            update.where(builder.greaterThanOrEqualTo(root.get("cost"), room.getCost()));
//            update.where(builder.greaterThanOrEqualTo(root.get("avatar"), room.getAvatar()));
//
//
//            session.createQuery(update).executeUpdate();
            return true;
        }catch (Exception ex){
            System.err.println("== Add room err =="+ex.getMessage()) ;
            ex.printStackTrace();
        }
        return false;
    }
    

    @Override
    public Room getRoomById(int roomid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Room.class, roomid);
    }

    @Override
    public List<Room> getRoom(String tm) {
          Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Room> query = builder.createQuery(Room.class);
        Root root = query.from(Room.class);
        query=query.select(root);
        if( tm!=null){
            Predicate p = builder.like(root.get("roomName").as(String.class), String.format("%%%s%%", tm));
            query=query.where(p);
        }
        Query q =session.createQuery(query);

       
        return q.getResultList();
    }

    @Override
    public boolean updateTinhTrang(Room r) {
        Session session= this.sessionFactory.getObject().getCurrentSession();
        try{
            Room room = this.getRoomById(r.getIdRoom());
            room.setTrangthai(Room.HETPHONG);
            session.update(room);
            return true;
        
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updTinhTrang(Room r) {
                Session session= this.sessionFactory.getObject().getCurrentSession();
        try{
          
            Room room = this.getRoomById(r.getIdRoom());
            room.setTrangthai(Room.CONPHONG);
            session.update(room);
            return true;
        
        }catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
