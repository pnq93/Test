package com.paweleck.quiz.repository;

import com.paweleck.quiz.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResultDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addResult(Result result){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(result);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
