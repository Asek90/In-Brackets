package org.ewarsztat.approach.event.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "CreatedQuestion")
public class CreatedQuestionEvent extends GenericEvent {

    public CreatedQuestionEvent(Long sheetId, String body) {
        this.sheetId = sheetId;
        this.body = body;
    }

    private Long sheetId;
    private String body;
}
