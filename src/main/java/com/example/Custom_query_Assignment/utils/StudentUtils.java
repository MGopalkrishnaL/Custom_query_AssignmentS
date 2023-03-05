package com.example.Custom_query_Assignment.utils;

import com.example.Custom_query_Assignment.model.Student;
import org.json.JSONObject;

import java.util.Date;


public class StudentUtils {

    public Student setStudent(String studentDetails) {
        JSONObject json = new JSONObject(studentDetails);
        Student student = new Student();
        student.setFirstName(json.getString("firstName"));
        student.setLastName(json.getString("lastName"));
        student.setAge(json.getInt("age"));
        student.setActive(json.getBoolean("active"));
         Date date = new Date();
        student.setAdmissionDate(date);
        return student;
    }
}
