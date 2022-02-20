package com.example.mainproject.repository;

import com.example.mainproject.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findByDept(int dept);

    @Bean
    @Query("update employee set salary=:salary where id=22")
    public default Employee findByIdUpdate(int id) {
        return null;
    }

}

