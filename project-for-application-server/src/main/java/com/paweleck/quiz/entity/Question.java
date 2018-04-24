package com.paweleck.quiz.entity;


import javax.persistence.*;

@Entity
@Table(name="Question")
public class Question {

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Response response;

    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "question")
    private String question;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
