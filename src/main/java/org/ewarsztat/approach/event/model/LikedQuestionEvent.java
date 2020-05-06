package org.ewarsztat.approach.event.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LikedQuestionEvent extends GenericEvent{
    public LikedQuestionEvent(Long questionId){
        this.questionId=questionId;
    }

    private Long questionId;
}
