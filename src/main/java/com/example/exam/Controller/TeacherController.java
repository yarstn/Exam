package com.example.exam.Controller;

import com.example.exam.Model.Teacher;
import com.example.exam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    //get
    @GetMapping("/get")
    public ArrayList<Teacher> getTeachers() {
        return getTeachers();
    }
    //add
    @PostMapping("/add")
public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("added successfully");
}
//update
@PutMapping("/update/{id}")
public ResponseEntity updateTeacher(@PathVariable int id,@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("updated successfully");
}
//delete
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        boolean success = teacherService.deleteTeacher(id);
        if (success) {
            return ResponseEntity.status(200).body("deleted successfully");
        }
        return ResponseEntity.badRequest().body("deletion failed");
}
@GetMapping("salary/{salary}")
    public ArrayList<Teacher> getTeacherBySalary(@PathVariable int salary) {
        return getTeacherBySalary(salary);
}


}
