package com.example.mainproject.EmployeeException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {

    public Date date;
    public String message;
    public String details;
}

