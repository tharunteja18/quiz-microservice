package com.nerchuko.quizservice.Service;

import com.nerchuko.quizservice.Model.QuestionWrapper;
import com.nerchuko.quizservice.Model.Quiz;
import com.nerchuko.quizservice.Model.Response;
import com.nerchuko.quizservice.Persistance.QuizDao;
import com.nerchuko.quizservice.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestions, String title) {

        List<Integer> questionsIds=quizInterface.getQuestionsForQuiz(category,noOfQuestions).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questionsIds);
        quizDao.save(quiz);



//        List<Integer> questions=//call the generate url from the question service--restTemplate

        //List<Question> questionsFromDb= questionDao.findRandomQuestionsByCategory(category,noOfQuestions);

//        Quiz quiz=new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questionsFromDb);
//        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
    {
        Optional<Quiz> quiz = quizDao.findById(id);
//        List<Question> questionsFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
//
//        for(Question q: questionsFromDb)
//        {
//            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getCategory(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
//            questionsForUser.add(qw);
//
//        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);



    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Quiz quiz = quizDao.findById(id).get();
//        List<Question> question = new ArrayList<>(quiz.getQuestions());
        int result=0;
//        int i=-1;
//        for(Response r:responses)
//        {
//            i++;
//            if(r.getResponse().equals(question.get(i).getRightAnswer()))
//            {
//                result++;
//            }
//        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
