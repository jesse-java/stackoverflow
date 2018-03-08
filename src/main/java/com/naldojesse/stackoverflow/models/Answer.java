package com.naldojesse.stackoverflow.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="answers")
public class Answer implements java.io.Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String answer;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    public Answer() {

    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}

