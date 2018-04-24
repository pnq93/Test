package com.paweleck.quiz.service;

import com.paweleck.quiz.entity.User;
import com.paweleck.quiz.repository.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(user);
            System.out.println("User is created With Id::" + id);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findOneByLoginAndPassword(String login, String password) {
        return userDao.findOneByLoginAndPassword(login, password);
    }
}
