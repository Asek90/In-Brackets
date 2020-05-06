package org.ewarsztat.approach.event.controller;

import lombok.Getter;
import lombok.Setter;
import org.ewarsztat.approach.event.model.LikedQuestionEvent;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class QuestionDto {
    private Long questionId;
    private String body;
    private long likes;
}
