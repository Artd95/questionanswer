package questionanswer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import questionanswer.EntityAndRepository.*;

import java.util.Map;
@Controller
public class AnswerController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    UserRepository userRepository;

    Question question;

    @GetMapping("/questionList/{question.id}")
    public String viewAnswerList(@PathVariable("question.id") Question pathquestion, Map<String, Object> model)
    {   Iterable<Answer> answer=answerRepository.findByQuestion(pathquestion);
        model.put("answers",answer);
        question = pathquestion;                // delete!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        model.put("question", question);
        return "answerList";}

    @PostMapping("/questionList/{question.id}")
    public String addNewAnswer(@PathVariable("question.id") Question pathquestion, @RequestParam String textA, @AuthenticationPrincipal User user, Map<String, Object> model) {
        question = pathquestion;
        model.put("question", question);
        Answer newAnsw = new Answer();
        newAnsw.setUser(user);
        newAnsw.setTextA(textA);
        newAnsw.setQuestion(question);
        answerRepository.save(newAnsw);
        Iterable<Answer> answer=answerRepository.findByQuestion(question);
        model.put("answers",answer);
        return "answerList";
    }
}
