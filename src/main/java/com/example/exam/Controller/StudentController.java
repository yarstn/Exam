package com.example.exam.Controller;
import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import com.example.exam.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
  public  ArrayList<Student> getStudent( ){
        return getStudent();
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(msg);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String msg = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(msg);
        }
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("updated successfully");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(int id){
        boolean success = studentService.deleteStudent(id);
     if(success) {
         return ResponseEntity.status(200).body("deleted successfully");
     }
     return ResponseEntity.badRequest().body("deletion failed");
     }
//     @GetMapping("/name/{name}")
//    public  ResponseEntity getStudentByName(@PathVariable String name){
//
//     }
    @GetMapping("/major/{major}")
    public ArrayList<Student> getStudentMajor(@PathVariable String major){
        return getStudentMajor(major);
    }


    }

