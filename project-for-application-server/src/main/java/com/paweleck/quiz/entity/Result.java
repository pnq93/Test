package com.paweleck.quiz.entity;

import javax.persistence.*;


@Entity
@Table(name="Result")
public class Result {

    @javax.persistence.Id
    @Column(name="result_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Question question;
    @Column(name = "user_respons")
    private String userResponse;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public String getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(String userResponse) {
        this.userResponse = userResponse;
    }
}
