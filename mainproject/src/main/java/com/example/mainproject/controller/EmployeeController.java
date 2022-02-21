package com.example.mainproject.controller;

import com.example.mainproject.EmployeeException.EmployeeNotFoundException;
import com.example.mainproject.Service.EmployeeService;
import com.example.mainproject.model.Employee;
import com.example.mainproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;
    @Autowired
    EmployeeService service;

    @GetMapping("/Employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }

    @GetMapping("/Employee/name/{id}")
    public String getEmployeeName(@PathVariable int id){
        if(!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
        }
        return service.getEmployeeName(id);
    }

    @GetMapping("/Employee/dept/{id}")
    public double getEmployeeDept(@PathVariable int id){
        if(!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
        }
        return service.getEmployeeDept(id);
    }

    @GetMapping("/Employee/salary/{id}")
    public double getEmployeeSalary(@PathVariable int id){
        if(!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
        }
        return service.getEmployeeSalary(id);
    }

    @PostMapping("/Employee/add")
    public Employee addEmployee(Employee employee){
        return service.addEmployee(employee);
    }

    @PutMapping("/Employee/update/{id}")
    public String updateEmployee(@PathVariable int id, Employee emp) {
        if (repo.existsById(id)) {
            return service.updateEmployee(id, emp);
        }
        else throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
    }
    @DeleteMapping("/Employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (repo.existsById(id)) {
            service.deleteEmployee(id);
            return "Employee deleted";
        }
        else throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
    }

    @GetMapping("/Employees/sort/{dept}")
    public List<Employee> getEmployeesAsc(@PathVariable int dept){
        return service.getEmployeesAsc(dept);
    }

}

