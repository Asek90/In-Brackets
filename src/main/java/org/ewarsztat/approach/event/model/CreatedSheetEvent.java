package org.ewarsztat.approach.event.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CreatedSheet")
public class CreatedSheetEvent extends GenericEvent {

    public CreatedSheetEvent(String title) {
        this.title = title;
    }

    private String title;
}
