package pro.sky.exam.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exam.model.Question;
import pro.sky.exam.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
@AllArgsConstructor

public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping
    public ResponseEntity<Collection<Question>> getQuestions(int amount){
        if(examinerService.getQuestions(amount)!=null){
            return ResponseEntity.ok(examinerService.getQuestions(amount));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
