package com.paweleck.quiz.service;

import com.paweleck.quiz.entity.Question;
import com.paweleck.quiz.repository.QuestDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QuestDao questDao;

    @Override
    public void createQuest(Question question) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Integer id = (Integer) session.save(question);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Question> getAllQuestions() {
        return questDao.getAllQuestions();
    }
}
