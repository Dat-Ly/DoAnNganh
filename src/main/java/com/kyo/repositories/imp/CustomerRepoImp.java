/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.repositories.imp;

import com.kyo.pojos.Customer;

import com.kyo.repositories.CustomerRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class CustomerRepoImp implements CustomerRepository{
        @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Customer> getCustomer(String kw) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root root = query.from(Customer.class);
        query=query.select(root);
        if( kw!=null){
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query=query.where(p);
        }
        Query q =session.createQuery(query);

       
        return q.getResultList();
    }

    @Override
    public boolean addCustomer(Customer cus) {
        Session session = sessionFactory.getObject().getCurrentSession();
        try {
            session.save(cus);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> getListCus() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Customer");
        return q.getResultList();
    }

    @Override
    public Customer getCusById(int cusid) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Customer.class, cusid);
    }

    @Override
    public boolean deleteCus(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        String hql = "delete from Customer where idCustomer.idCustomer=:id";
        session.createQuery(hql).setParameter("id", id).executeUpdate();
        return true;
    }



    @Override
    public boolean updateCus( Customer cusnew) {
                     Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            Customer c = this.getCusById(cusnew.getIdCustomer());
            c.setName(cusnew.getName());
            c.setPhone(cusnew.getPhone());
            c.setEmail(cusnew.getEmail());
            c.setIdRoom(cusnew.getIdRoom());
            session.update(c);
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaUpdate<Customer> update = builder.createCriteriaUpdate(Customer.class);
//
//            Root root = update.from(Customer.class);
//
//            update.set("name", cusnew.getName());
//            update.set("phone", cusnew.getPhone());
//            update.set("email", cusnew.getEmail());
//            update.set("idRoom", cusnew.getIdRoom());
//            
//
//            update.where(builder.greaterThanOrEqualTo(root.get("name"), cus.getName()));
//            update.where(builder.greaterThanOrEqualTo(root.get("phone"), cus.getPhone()));
//            update.where(builder.greaterThanOrEqualTo(root.get("email"), cus.getEmail()));
//            
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
    
}
