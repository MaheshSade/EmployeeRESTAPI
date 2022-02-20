package com.example.mainproject;

import com.example.mainproject.model.Employee;
import com.example.mainproject.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.el.stream.Stream.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainprojectApplicationTests {
    @Autowired
    EmployeeController con;
    @MockBean
    EmployeeRepository repo;

    @Test
    public void getAllEmployeesTest(){
        when(repo.findAll()).thenReturn(Stream.of(new Employee(1,"slkndvl",5346,111)).collect(Collectors.toList()));
        assertEquals(1,con.getAllEmployees().size());
    }
    
    
    @Test
    public void addEmployeeTest(){
        Employee e =new Employee(1,"mahesh",53464,111);
        when(repo.save(e)).thenReturn(e);
        assertEquals(e,con.addEmployee(e));

    }


    @Test
    public void deleteEmployeeTest(){
        Employee e =new Employee(1,"mahesh",53464,111);
        repo.delete(e);
        verify(repo,times(1)).delete(e);
    }

    
}
