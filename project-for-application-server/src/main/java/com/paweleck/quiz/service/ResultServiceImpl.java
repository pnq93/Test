package com.paweleck.quiz.service;

import com.paweleck.quiz.entity.Result;
import com.paweleck.quiz.repository.ResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDao resultDao;

    @Override
    public void addResult(Result result) {
        resultDao.addResult(result);
    }
}
