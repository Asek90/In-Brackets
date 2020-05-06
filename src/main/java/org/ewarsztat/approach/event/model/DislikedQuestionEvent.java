package org.ewarsztat.approach.event.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DislikedQuestionEvent extends GenericEvent{
    public DislikedQuestionEvent(Long questionId){
        this.questionId=questionId;
    }
    private Long questionId;
}
