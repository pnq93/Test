package com.paweleck.quiz.repository;


import com.paweleck.quiz.entity.Question;
import com.paweleck.quiz.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestDao {

    @Autowired
    private SessionFactory sessionFactory;


//    public void createQuest(Question question) {
//
//        Session session = null;
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            Integer id = (Integer) session.save(question);
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public List<Question> getAllQuestions(){
        Session session = sessionFactory.openSession();
        List<Question> questions = session.createCriteria(Question.class).list();
        session.close();
        return  questions;
    }
}
