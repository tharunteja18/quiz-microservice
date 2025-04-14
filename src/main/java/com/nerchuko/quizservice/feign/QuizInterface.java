package com.nerchuko.quizservice.feign;


import com.nerchuko.quizservice.Model.QuestionWrapper;

import com.nerchuko.quizservice.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient("question-service")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>>getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer noOfQuestions);

    //getQuestions--> postMapping from quizService we get list of questionIds
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    //score
    @PostMapping("question/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
