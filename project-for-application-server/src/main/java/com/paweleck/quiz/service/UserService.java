package com.paweleck.quiz.service;

import com.paweleck.quiz.entity.User;

public interface UserService {
    public void createUser(User user);
    public User findOneByLoginAndPassword(String login, String password);
}
