package com.example.mainproject.controller;

import com.example.mainproject.EmployeeException.EmployeeNotFoundException;
import com.example.mainproject.model.Employee;
import com.example.mainproject.model.EmployeeList;
import com.example.mainproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static com.example.mainproject.model.EmployeeList.list;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;
    @Autowired
    Employee e;
    @Autowired
    EmployeeList employeeList;


    @GetMapping("/Employees")
    public List<Employee> getAllEmployees(){
        if(repo.findAll().isEmpty()){
            throw new EmployeeNotFoundException("No employees found");
        }
        return repo.findAll();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return repo.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee with id:"+id+" does not exist"));
    }

    @GetMapping("/Employee/salary/{id}")
    public int getEmployeeSalary(@PathVariable int id){
        return repo.findById(id).get().getSalary();
    }

    @PutMapping("/Employee/add")
    public Employee addEmployee(Employee employee){
        repo.save(employee);
        return employee;
    }

    @PutMapping("/Employee/update/{id}")
    public Employee updateEmployee(@PathVariable int id) {

        return repo.findByIdUpdate(id);
    }

    @DeleteMapping("/Employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Employee deleted";
        }
        else throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
    }

    @GetMapping("/Employees/sort/{dept}")
    public List<Employee> getEmployeesAsc(@PathVariable int dept){
        return repo.findByDept(dept);
    }
}

