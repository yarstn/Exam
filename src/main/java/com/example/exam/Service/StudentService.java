package com.example.exam.Service;

import com.example.exam.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<Student>();

    public  ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public Student updateStudent(int id, Student student) {
        for (int i = 0 ; i < students.size() ; i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return student;
            }
        }
        return null;
    }
    public boolean deleteStudent(int id) {
        for (int i = 0 ; i < students.size() ; i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
//get student by name
    public Student getStudentName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
    //get student by major
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> studentsByMajor = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(major)){
                studentsByMajor.add(student);
                return studentsByMajor;
            }
        }
        return null;
    }
}
