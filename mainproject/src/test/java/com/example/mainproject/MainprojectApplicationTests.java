package com.example.mainproject;

import com.example.mainproject.Service.EmployeeService;
import com.example.mainproject.model.Employee;
import com.example.mainproject.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainprojectApplicationTests {
    @Autowired
    EmployeeService service;
    @MockBean
    EmployeeRepository repo;

    @Test
    public void getAllEmployeesTest(){
        when(repo.findAll()).thenReturn(Stream.of(new Employee(1,"slkndvl",5346,111)).collect(Collectors.toList()));
        assertEquals(1,service.getAllEmployees().size());
    }
    @Test
    public void getEmployeeTest() {
        int id = 1;
        Employee e =new Employee(1,"mahesh",53464,111);
        when(repo.findById(id)).thenReturn(Optional.of(e));
        assertEquals(e,service.getEmployee(id));
    }
    @Test
    public void getEmployeeNameTest() {
        int id =2;
        Employee e =new Employee(2,"mahesh",53464,111);
        when(repo.getById(id)).thenReturn(e);
        assertEquals("mahesh",service.getEmployeeName(e.getId()));
    }
    @Test
    public void getEmployeeSalaryTest() {
        int id =2;
        Employee e =new Employee(2,"mahesh",53464,111);
        when(repo.getById(id)).thenReturn(e);
        assertEquals(53464,service.getEmployeeSalary(e.getId()));
    }
    @Test
    public void getEmployeeDeptTest() {
        int id =2;
        Employee e =new Employee(2,"mahesh",53464,111);
        when(repo.getById(id)).thenReturn(e);
        assertEquals(111,service.getEmployeeDept(e.getId()));
    }
    @Test
    public void addEmployeeTest(){
        Employee e =new Employee(1,"mahesh",53464,111);
        when(repo.save(e)).thenReturn(e);
        assertEquals(e,service.addEmployee(e));

    }
    @Test
    public void updateEmployeeTest() {
        int id = 2;
        Employee e = new Employee(2, "mahesh", 53464, 111);
        when(repo.getById(id)).thenReturn(e);
        assertEquals(false,service.updateEmployee(e.getId(),e).isEmpty());
    }

    @Test
    public void deleteEmployeeTest(){
        Employee e =new Employee(1,"mahesh",53464,111);
        repo.delete(e);
        verify(repo,times(1)).delete(e);
    }
    @Test
    public void getEmployeesAscTest(){
        Employee e =new Employee(1,"mahesh",53464,111);
        when(repo.findAllByDept(e.getDept())).thenReturn(List.of(e));
        assertEquals(1,service.getEmployeesAsc(e.getDept()).size());
    }
}