package com.paweleck.quiz.service;

import com.paweleck.quiz.entity.Question;

import java.util.List;

public interface QuestService {
    public void createQuest(Question question);
    public List<Question> getAllQuestions();

}
