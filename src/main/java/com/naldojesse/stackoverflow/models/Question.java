package com.naldojesse.stackoverflow.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="questions")
public class Question implements java.io.Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String question;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private Set<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name="tags_questions",
            joinColumns = @JoinColumn(name="question_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    @Size(max=3)
    private Set<Tag> tags = new HashSet<>();


    public Question() {

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

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
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
