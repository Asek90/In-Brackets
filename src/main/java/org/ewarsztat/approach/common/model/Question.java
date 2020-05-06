package org.ewarsztat.approach.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue
    private Long questionId;
    private String body;
    private long questionLikeCounter;
    private long disLike;
    public Question() {
    }

    public Question(String body, Sheet sheet) {
        this.body = body;
        this.sheet = sheet;
    }

    @JsonIgnoreProperties(value = {"questions"})
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Sheet sheet;

}
