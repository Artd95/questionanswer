package questionanswer.EntityAndRepository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    public List<Question> findByText(String text);
}
