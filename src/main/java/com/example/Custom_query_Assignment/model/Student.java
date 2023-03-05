package com.example.Custom_query_Assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @Length(min = 3,max = 20,message = "Please enter the name with int the length of 3-20 characters")
    private String firstName;
    @Length(min = 3,max = 20,message = "Please enter the name with int the length of 3-20 characters")
    private String LastName;
    @Digits(fraction = 0,integer = 2,message = "please enter the valid age")
    private Integer age;
    private boolean active;
    private Date admissionDate;
}
