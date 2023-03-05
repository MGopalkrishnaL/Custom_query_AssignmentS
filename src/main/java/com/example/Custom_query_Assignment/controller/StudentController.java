package com.example.Custom_query_Assignment.controller;

import com.example.Custom_query_Assignment.model.Student;
import com.example.Custom_query_Assignment.service.StudentService;
import com.example.Custom_query_Assignment.utils.StudentUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
public class StudentController {
    @Autowired
    StudentUtils studentUtils;
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/getAll")
    public List<Student> getall(){
        return studentService.getAll();
    }
    @PostMapping(value = "/createStudent")
    public ResponseEntity create(@Valid @RequestBody String StudentDetails){
        Student student  = studentUtils.setStudent(StudentDetails);
        return studentService.saveStudent(student);
     }
     @PutMapping(value = "/UpdateStudent/{firstName}")
    public ResponseEntity update(@PathVariable String firstName,@RequestBody String student){
         return studentService.updateStudent(firstName,student);
     }
    @GetMapping(value = "/StudentAgebetween/")
    public List<Student> getByage(@RequestParam Integer toage,@RequestParam Integer fromage){
        return studentService.getBetweenage(fromage,toage);
    }

////    Student findByLastNameAndFirstName(String firstName,String LastName);
    @GetMapping(value = "/getstudentbyfirstnameandlastname")
    public Student findStudent(@RequestParam String firstName,@RequestParam String lastName){
        return studentService.findusingLastNameandFirstName(firstName, lastName);
    }
//    List<Student> findByLastNameOrFirstName(String firstName,String lastName);
    @GetMapping(value = "/getStudentsbyLastnameorfirstname")
    public List<Student> findstudentsbylastnameorfirstname(@RequestParam String firstname,@RequestParam String lastname){
        return studentService.findUsingfirstNameorlastname(firstname, lastname);
    }

////    List<Student> findByAgeLessThanEqual(Integer age);
    @GetMapping(value = "/findagelessthanorequalsage")
    public List<Student> findstudentsUsingle(@RequestParam Integer age){
        return studentService.findbyagelessthanequal(age);
    }
////    List<Student> findByAgeGreaterThanEqual(Integer age);
    @GetMapping(value = "/findageGreatethanorequals")
    public List<Student> findstudentagegreater(@RequestParam Integer age){
        return studentService.findbyagegreaterthanequal(age);
    }
//    List<Student> findByFirstNameContaining(String name);
    @GetMapping(value = "/findbyfirstnameContians")
    public List<Student> findallstu(@RequestParam String name){
        return studentService.findbyusingContains(name);
    }
//
//    List<Student> findByActiveTrue();
    @GetMapping(value = "/getallstudents/Active")
    public List<Student> findallstudentswhoseactive(){
        return studentService.getactivestudents();
    }
//    List<Student> findByActiveFalse();
    @GetMapping(value = "/getallstudents/Inactive")
    public List<Student> findallstudentwhoareInactive(){
        return studentService.getInactive();
    }


}
