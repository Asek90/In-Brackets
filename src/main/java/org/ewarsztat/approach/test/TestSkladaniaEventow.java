package org.ewarsztat.approach.test;

import org.ewarsztat.approach.common.model.Question;
import org.ewarsztat.approach.common.model.Sheet;

import java.util.ArrayList;
import java.util.List;

public class TestSkladaniaEventow {


    public static void main(String[] args) {

        Sheet sheet = new Sheet();

        List<Event> events = new ArrayList<>(); // getAllBySheetId(100);



        Event event = events.get(0);
        if (event instanceof CreatedSheetEvent){
            CreatedSheetEvent sheetEvent = (CreatedSheetEvent) event;
            sheet.setId(sheetEvent.sheetId);
            sheet.setTitle(sheetEvent.title);
        }
        if (event instanceof CreatedQuestionEvent){
            CreatedQuestionEvent createdQuestionEvent = (CreatedQuestionEvent) event;
            Question question = new Question();
            question.setBody(createdQuestionEvent.questionBody);

        }

        System.out.println("Nieobsługiwany event");
    }

    private static void useEvent(Event event) {
        System.out.println(event.id);
    }

}


class Event{
    long id;
    long sheetId;

};
class CreatedSheetEvent extends  Event{

    String title;

};
class CreatedQuestionEvent extends  Event{

    String questionBody;

};