package com.example.mainproject.model;

import com.example.mainproject.model.Employee;
import com.example.mainproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeList {
    @Autowired
    EmployeeRepository repo;
    public static List<Employee> list = new ArrayList<>();

    //    static {
//        list.add(new Employee(1, "derd", 54654, "hir6u"));
//        list.add(new Employee(2,"svfb",5451,"hosg"));
//    }
    public void ce(){
//        list = repo.saveAll(repo.findAll());

    }
}