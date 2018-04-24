package com.paweleck.quiz.repository;

import com.paweleck.quiz.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

//    public void createUser(User user) {
//
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            Integer id = (Integer) session.save(user);
//            System.out.println("User is created With Id::" + id);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public User findOneByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.openSession();
        User user = (User) session.createCriteria(User.class).add(Restrictions.eq("name", login))
                .add(Restrictions.eq("password", password)).uniqueResult();
        session.close();
        return user;
    }
}
