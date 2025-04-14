package com.nerchuko.quizservice.Persistance;


import com.nerchuko.quizservice.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
