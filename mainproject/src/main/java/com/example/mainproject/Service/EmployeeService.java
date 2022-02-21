package com.example.mainproject.Service;

import com.example.mainproject.EmployeeException.EmployeeNotFoundException;
import com.example.mainproject.model.Employee;
import com.example.mainproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;
    @Autowired
    Employee e;

    @GetMapping("/Employees")
    public List<Employee> getAllEmployees(){
        if(repo.findAll().isEmpty()){
            throw new EmployeeNotFoundException("No employees found");
        }
        return repo.findAll();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return (repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id:" + id + " does not exist")));
    }

    @GetMapping("/Employee/name/{id}")
    public String getEmployeeName(@PathVariable int id){
        return repo.getById(id).getName();
    }

    @GetMapping("/Employee/dept/{id}")
    public int getEmployeeDept(@PathVariable int id){
        if(!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
        }
        return repo.findById(id).get().getDept();
    }

    @GetMapping("/Employee/salary/{id}")
    public int getEmployeeSalary(@PathVariable int id){
        if(!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" does not exist");
        }
        return repo.findById(id).get().getSalary();    }

    @PutMapping("/Employee/add")
    public Employee addEmployee(Employee employee){
        if(employee==null){
            throw new EmployeeNotFoundException("Add an employee!");
        }
        repo.save(employee);
        return employee;
    }

    @PutMapping("/Employee/update/{id}")
    public String updateEmployee(@PathVariable int id, Employee emp) {
            if(emp.getSalary()!=0) {
                repo.getById(id).setSalary(emp.getSalary());
                repo.save(repo.getById(id));
                return "Employee updated";
            }
            else throw new EmployeeNotFoundException("Add an employee");
    }

    @DeleteMapping("/Employee/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
            repo.deleteById(id);
    }

    @GetMapping("/Employees/sort/{dept}")
    public List<Employee> getEmployeesAsc(@PathVariable int dept){
        if(repo.findAllByDept(dept).isEmpty()){
            throw new EmployeeNotFoundException("No employees found");
        }
        return repo.findAllByDept(dept);
    }
}
