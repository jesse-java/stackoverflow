package com.naldojesse.stackoverflow.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//class NotUniqueSubjectException extends Exception{}

@Entity
@Table(name="tags")
public class Tag implements java.io.Serializable{
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String subject;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "tags")
    private Set<Question> questions = new HashSet<>();

    public Tag() {

    }

    public Tag(String subject) {
        this.subject = subject;
//        throw new NotUniqueSubjectException();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        System.out.println("setting the subject");
        this.subject = subject;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
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
