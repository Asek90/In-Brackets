package org.ewarsztat.approach.event.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "DeletedSheet")
public class DeletedSheetEvent extends GenericEvent {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private final String title;

    public DeletedSheetEvent(String title) {
       // super(title);
        this.title = title;
    }
}
