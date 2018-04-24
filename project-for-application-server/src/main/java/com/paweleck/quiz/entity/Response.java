package com.paweleck.quiz.entity;

import javax.persistence.*;

@Entity
@Table(name = "Response")
public class Response {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "response_1")
    private String firstResponse;

    @Column(name = "response_2")
    private String secondResponse;

    @Column(name = "response_3")
    private String thirdResponse;

    @Column(name = "response_4")
    private String fourthResponse;

    @Column(name = "correctResponse")
    private String correctResponse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstResponse() {
        return firstResponse;
    }

    public void setFirstResponse(String firstResponse) {
        this.firstResponse = firstResponse;
    }

    public String getSecondResponse() {
        return secondResponse;
    }

    public void setSecondResponse(String secondResponse) {
        this.secondResponse = secondResponse;
    }

    public String getThirdResponse() {
        return thirdResponse;
    }

    public void setThirdResponse(String thirdResponse) {
        this.thirdResponse = thirdResponse;
    }

    public String getFourthResponse() {
        return fourthResponse;
    }

    public void setFourthResponse(String fourthResponse) {
        this.fourthResponse = fourthResponse;
    }

    public String getCorrectResponse() {
        return correctResponse;
    }

    public void setCorrectResponse(String correctResponse) {
        this.correctResponse = correctResponse;
    }
}
