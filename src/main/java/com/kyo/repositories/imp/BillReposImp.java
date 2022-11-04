/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.repositories.imp;

import com.kyo.pojos.Bill;
import com.kyo.pojos.Customer;
import com.kyo.repositories.BillRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class BillReposImp implements BillRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addBill(Bill bill) {
        Session session= this.sessionFactory.getObject().getCurrentSession();
        try{
        session.save(bill);
        return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
      
        return false;
    }

    @Override
    public Bill getBillById(int idBill) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Bill.class, idBill);
    }

    @Override
    public List<Bill> getListBill() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("From Bill");
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
//        Root root = query.from(Customer.class);
//        query=query.select(root);
//        
//        Predicate p = builder.equal(root.get("idRoom"),id);
//        query=query.where(p);
//        
//        Query q =session.createQuery(query);
        return q.getResultList();
    }
    
}
