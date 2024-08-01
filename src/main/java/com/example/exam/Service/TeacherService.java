package com.example.exam.Service;

import com.example.exam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    //get
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    //add
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    //update
    public boolean updateTeacher(int id, Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }
    //delete
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                teachers.remove(id);
                return true;
            }
        }
        return false;
    }
    //get by salary
    public  ArrayList<Teacher> getTeacherBySalary(int salary) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getSalary() == salary || teachers.get(i).getSalary() > salary) {
                teachers.add(teachers.get(i));
                return teachers;
            }
        }
        return teachers;
    }
}
