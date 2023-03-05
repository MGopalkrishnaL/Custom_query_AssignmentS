package com.example.Custom_query_Assignment.dao;

import com.example.Custom_query_Assignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IStudentRepo extends JpaRepository<Student,String> {
    Student findByFirstName(String firstName);
    List<Student>findByAgeBetween(Integer fromage , Integer toage);
    @Query(value = "select * from tbl_student where first_name = :firstName and last_name=:LastName",nativeQuery = true)
    Student findByLastNameAndFirstName(String firstName,String LastName);
    @Query(value = "select * from tbl_student where first_name =:firstName or last_name =:lastName",nativeQuery = true)
    List<Student> findByLastNameOrFirstName(String firstName,String lastName);
    @Query(value = "select * from tbl_student where age<=:age",nativeQuery = true)
    List<Student> findByAgeLessThanEqual(Integer age);
    @Query(value = "select * from tbl_student where age>=:age",nativeQuery = true)
    List<Student> findByAgeGreaterThanEqual(Integer age);

    @Query(value = "select * from tbl_student where first_name like :name",nativeQuery = true)
    List<Student> findByFirstNameContaining(String name);
    @Query(value = "select * from tbl_student where active = '1'",nativeQuery = true)
    List<Student> findByActiveTrue();
    @Query(value = "select * from tbl_student where active = '0'",nativeQuery = true)
    List<Student> findByActiveFalse();

}
