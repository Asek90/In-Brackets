package org.ewarsztat.approach.event.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SheetDto {
    private Long id;
    private String title;
    private List<QuestionDto> questions = new ArrayList<>();

    public SheetDto(String title) {
        this.title = title;
    }

}

