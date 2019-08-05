package questionanswer.EntityAndRepository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    public List<Answer> findByTextA(String textA);
    public List<Answer> findByQuestion(Question question);
}
