package org.ewarsztat.approach.event.controller;

import lombok.RequiredArgsConstructor;
import org.ewarsztat.approach.common.model.Question;
import org.ewarsztat.approach.common.model.Sheet;
import org.ewarsztat.approach.event.model.*;
import org.ewarsztat.approach.event.service.EventSheetService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController("EventController")
@RequiredArgsConstructor
@RequestMapping("/event/sheet")
public class SheetController {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final EventSheetService eventSheetService;

    @RequestMapping("/all")
    public List<SheetDto> getAllSheets() {
        List<GenericEvent> all = eventSheetService.getAll();
        List<SheetDto> sheetList = buildSheetDto(all);
        return sheetList;
    }

    @RequestMapping("/{id}")
    public SheetDto getById(@PathVariable("id") Long id) {
        List<GenericEvent> byId = eventSheetService.getById(id);
        return buildSheetDto(byId).stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cannot build sheet with id " + id));
    }

    @PostMapping("/add")
    @ResponseBody
    public void saveCreatedSheetEvent(@RequestBody String title) {
        CreatedSheetEvent createdSheetEvent = new CreatedSheetEvent(title);
        applicationEventPublisher.publishEvent(createdSheetEvent);
    }

    @PostMapping("/{id}/question")
    @ResponseBody
    public void saveCreatedQuestionEvent(@PathVariable("id") Long id, @RequestBody String body) {
        CreatedQuestionEvent createdQuestionEvent = new CreatedQuestionEvent(id, body);
        applicationEventPublisher.publishEvent(createdQuestionEvent);
    }
    @PutMapping("/like/{id}")
    public void like(@PathVariable("id") Long id){
        LikedQuestionEvent likedQuestionEvent = new LikedQuestionEvent(id);
        applicationEventPublisher.publishEvent(likedQuestionEvent);
    }

    @DeleteMapping("/dislike/{id}")
    public void disLike(@PathVariable("id") Long id){
        DislikedQuestionEvent dislikedQuestionEvent  = new DislikedQuestionEvent(id);
        applicationEventPublisher.publishEvent(dislikedQuestionEvent);
    }

    private List<SheetDto> buildSheetDto(List<GenericEvent> all) {

        final Map<Long, List<LikedQuestionEvent>> likeEvents = all.stream()
                .filter(a -> a instanceof LikedQuestionEvent)
                .map(a -> (LikedQuestionEvent) a)
                .collect(Collectors.groupingBy(LikedQuestionEvent::getQuestionId));

        final Map<Long, List<CreatedQuestionEvent>> questionEvents = all.stream()
                .filter(a -> a instanceof CreatedQuestionEvent)
                .map(a -> (CreatedQuestionEvent) a)
                .collect(Collectors.groupingBy(CreatedQuestionEvent::getSheetId));

        final List<SheetDto> sheetDtos = all.stream()
                .filter(a -> a instanceof CreatedSheetEvent)
                .map(a -> (CreatedSheetEvent) a)
                .map(createdSheetEvent -> {
                    final SheetDto sheet = new SheetDto();
                    sheet.setId(createdSheetEvent.getId());
                    sheet.setTitle(createdSheetEvent.getTitle());
                    final List<QuestionDto> questionDtoList =
                            questionEvents.getOrDefault(createdSheetEvent.getId(), new ArrayList<>()).stream()
                                    .map(q -> {
                                        QuestionDto questionDto = new QuestionDto();
                                        List<LikedQuestionEvent> likes = likeEvents.getOrDefault(q.getId(), new ArrayList<>());
                                        questionDto.setLikes(likes.size());
                                        questionDto.setBody(q.getBody());
                                        questionDto.setQuestionId(q.getId());
                                        return questionDto;
                                    }).collect(Collectors.toList());
                    sheet.setQuestions(questionDtoList);

                    return sheet;
                }).collect(Collectors.toList());

        return sheetDtos;
    }
}
