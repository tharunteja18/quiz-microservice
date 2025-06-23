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


        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id)
    {


        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds=quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questions =quizInterface.getQuestionsFromId(questionIds);


        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {




        ResponseEntity<Integer> score  = quizInterface.getScore(responses);

        return score;
    }
}
