package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.model.Question;

import java.util.List;

public interface QuestionService {
    Question findById(Long id);
    Question save(Question question);
    List<Question> findAll();
}
