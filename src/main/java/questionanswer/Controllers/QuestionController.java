package questionanswer.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import questionanswer.Convert;
import questionanswer.EntityAndRepository.Question;
import questionanswer.EntityAndRepository.QuestionRepository;
import questionanswer.EntityAndRepository.User;
import questionanswer.EntityAndRepository.UserRepository;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Controller // This anotation indicates that this class is a controller.
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserRepository userRepository;




    @GetMapping("/") //Annotation indicates that "method()" will be called when going to the "/address"
    public String home() {
        return "home";
    }

    @GetMapping("/questionList")
    public String viewQuestionList(Map<String, Object> model)
    {   Iterable<Question> question=questionRepository.findAll();
        model.put("questions",question);
        return "questionList";}

    @PostMapping("/questionList")
    public String addNewQuestion(@RequestParam String text, @AuthenticationPrincipal User user, Map<String, Object> model) {
        Question newQue = new Question();
        newQue.setText(text);
        newQue.setUser(user);
        String currenttime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        newQue.setDtpost((Timestamp) Convert.convertToTimeStamp(Convert.convertToDate(currenttime)));
        questionRepository.save(newQue);
        Iterable<Question> question=questionRepository.findAll();
        model.put("questions",question);
        System.out.println(newQue.getDtpost());
        return "questionList";
    }

    @PostMapping ("/search")
        public String searchQuestion(@RequestParam String search, Map<String, Object> model) {
            Iterable<Question> question = questionRepository.findByText(search);
            model.put("questions", question);
            return "search";}

}
