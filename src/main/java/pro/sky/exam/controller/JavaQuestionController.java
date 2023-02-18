package pro.sky.exam.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.exam.model.Question;
import pro.sky.exam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
@AllArgsConstructor
public class JavaQuestionController {

   private final QuestionService questionService;

@PostMapping("/add")
public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
    if (question != null) {
        questionService.questionAdd(question);
        return ResponseEntity.ok(question);
    }
    return ResponseEntity.notFound().build();
}
@DeleteMapping("/remove")
    public ResponseEntity<Question> deleteQuestion(@RequestBody Question question){
    if(questionService.remove(question)){
        return ResponseEntity.ok(question);
    }
    return ResponseEntity.notFound().build();
}
@GetMapping
    public ResponseEntity<Collection<Question>> getAll(){
return ResponseEntity.ok(questionService.getAll());
}

}
