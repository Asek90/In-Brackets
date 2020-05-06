package org.ewarsztat.approach.event.model;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="descriminatorColumn")
@Table(name="AbstractCatalog")
public abstract class GenericEvent extends ApplicationEvent {

    public GenericEvent() {
        super("");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sheetId;
}