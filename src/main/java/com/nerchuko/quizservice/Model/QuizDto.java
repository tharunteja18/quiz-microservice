package com.nerchuko.quizservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDto {

    private String category;
    private Integer noOfQuestions;
    private String title;
}
