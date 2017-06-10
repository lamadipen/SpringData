package com.dipen.hibernatedao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by dipen on 6/9/2017.
 */
@Repository
public class CircleHbmDaoImpl {
    @Autowired
    private SessionFactory sessionFactory;
    /*
   We need to instiantiate SessionFactory in this manner if we don't use spring configuration
   */
  public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Integer getCount()
    {
        String hql = "SELECT  count(*)FROM Circle";
        Query query =  getSessionFactory().openSession().createQuery(hql);
        return ((Long)query.uniqueResult()).intValue();
    }



}
