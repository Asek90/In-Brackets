package org.ewarsztat.approach.common.service;

import org.ewarsztat.approach.common.model.Question;
import org.ewarsztat.approach.common.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public void save(Question question) {
        questionRepository.save(question);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    public Question getOneById(Long id) {
        return questionRepository.getOne(id);
    }
}
