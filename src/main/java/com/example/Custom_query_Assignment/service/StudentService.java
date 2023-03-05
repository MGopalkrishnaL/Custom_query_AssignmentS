package com.example.Custom_query_Assignment.service;

import com.example.Custom_query_Assignment.dao.IStudentRepo;
import com.example.Custom_query_Assignment.model.Student;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public ResponseEntity saveStudent(Student student) {
        if(student!=null) {
            studentRepo.save(student);
            return new ResponseEntity<>("Student saved to database successfully"+student.getFirstName(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Student is not saved ",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity updateStudent(String firstName, String student) {
        Student student2 = studentRepo.findByFirstName(firstName);
        if(student2!=null){
            JSONObject json = new JSONObject(student);
            student2.setFirstName(json.getString("firstName"));
            student2.setLastName(json.getString("lastName"));
            student2.setAge(json.getInt("age"));
            studentRepo.save(student2);
            return new ResponseEntity<>("Save the student",HttpStatus.OK);
        }
        return new ResponseEntity<>("Cannot find the Student ",HttpStatus.NOT_FOUND);
    }
    public List<Student> getBetweenage(Integer fromage, Integer toage){
        return studentRepo.findByAgeBetween(fromage,toage);
    }
////    Student findByLastNameAndFirstName(String firstName,String LastName);
    public Student findusingLastNameandFirstName(String firstName,String lastName){
        return studentRepo.findByLastNameAndFirstName(firstName,lastName);
    }
////    List<Student> findByLastNameOrFirstName(String firstName,String lastName);
    public List<Student> findUsingfirstNameorlastname(String firstname,String lastname){
        return studentRepo.findByLastNameOrFirstName(firstname,lastname);
    }

//    List<Student> findByAgeLessThanEqual(Integer age);
    public List<Student> findbyagelessthanequal(Integer age){
        return studentRepo.findByAgeLessThanEqual(age);
    }
//    List<Student> findByAgeGreaterThanEqual(Integer age);
    public List<Student> findbyagegreaterthanequal(Integer age){
        return studentRepo.findByAgeGreaterThanEqual(age);
    }

    public List<Student> findbyusingContains(String name) {
        return studentRepo.findByFirstNameContaining(name);
    }
    public List<Student> getactivestudents() {
        return studentRepo.findByActiveTrue();
    }

    public List<Student> getInactive() {
        return studentRepo.findByActiveFalse();
    }
}
