package org.ewarsztat.approach.common.controller;

import org.ewarsztat.approach.common.model.Question;
import org.ewarsztat.approach.common.model.Sheet;
import org.ewarsztat.approach.common.service.QuestionService;
import org.ewarsztat.approach.common.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("CommonController")
@RequestMapping("/common/sheet")
public class SheetController {
    @Autowired
    SheetService sheetService;

    @Autowired
    QuestionService questionService;


    @GetMapping("/add")
    public String registration(Model model) {
        model.addAttribute("sheetForm", new Sheet());

        return "welcome";
    }

    @RequestMapping("/all")
    public List<Sheet> getAllSheets() {
        return sheetService.getAll();
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Optional<Sheet> getById(@PathVariable("id") Long id) {
        return sheetService.getById(id);
    }

//    @PostMapping("/add")
//    @ResponseBody
//    public void saveSheet(@RequestBody String title) {
//        sheetService.save(new Sheet(title));
//    }

    @PostMapping("/add")
    @ResponseBody
    public void saveSheet(@ModelAttribute("sheetForm") Sheet sheetForm) {
        sheetService.save(sheetForm);
    }

    @DeleteMapping("/{id}")
    public void deleteSheet(@PathVariable("id") Long id) {
        sheetService.delete(id);
    }

    @PostMapping("/{id}/question")
    public void saveQuestion(@PathVariable("id") Long id, @RequestBody String questionBody) {
        Sheet sheet = new Sheet();
        sheet.setId(id);
        Question question = new Question();
        question.setBody(questionBody);
        question.setSheet(sheet);
        questionService.save(question);
    }

    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.delete(id);
    }

    @PostMapping(value = "/{id}/like")
    public void saveLike(@PathVariable("id") Long id) {
        Question question = questionService.getOneById(id);
        question.setQuestionLikeCounter(question.getQuestionLikeCounter()+1);
        question.setQuestionId(id);
        questionService.save(question);
    }

    @PostMapping(value = "/{id}/dissLike")
    public void dissLike(@PathVariable("id") Long id) {
        Question question = questionService.getOneById(id);
        question.setQuestionLikeCounter(question.getQuestionLikeCounter()-1);
        question.setQuestionId(id);
        questionService.save(question);
    }
}
