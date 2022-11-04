/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.repositories.imp;

import com.kyo.pojos.Bill;
import com.kyo.repositories.ThongKeRepo;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class ThongKeRepoImp implements ThongKeRepo{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> MonthStats() {
        Session session= this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root root = q.from(Bill.class);
        q.multiselect(b.function("MONTH", Integer.class, root.get("createDate")),b.function("YEAR", Integer.class, root.get("createDate")),b.sum(root.get("total")));
        q.groupBy(b.function("MONTH", Integer.class, root.get("createDate")),b.function("YEAR", Integer.class, root.get("createDate")));
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
