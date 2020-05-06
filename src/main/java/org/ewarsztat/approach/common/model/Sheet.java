package org.ewarsztat.approach.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Sheet {
    public Sheet(){}
    public Sheet(String title) {
        this.title = title;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;


    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "sheet")
    private List<Question> questions;

}
