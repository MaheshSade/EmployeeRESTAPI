package com.example.mainproject.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "employee")
public class Employee {
    @Id
    public int id;
    public String name;
    public int salary;
    @Column(name = "dept_id")
    public int dept;
}

