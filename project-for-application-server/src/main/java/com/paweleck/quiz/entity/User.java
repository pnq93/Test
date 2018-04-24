package com.paweleck.quiz.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="User")
public class User {
    @javax.persistence.Id
    @Column(name="user_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;

    @Column(name="name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="date_of_joining")
    private Date joinDate;

    @Column(name = "email")
    private String email;

    @Column(name = "score")
    private String score;

    @OneToMany(targetEntity = Result.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Result> results;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
