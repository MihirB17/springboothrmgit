package com.fullstack.controller;

import com.fullstack.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping
public class EmployeeController {

    List<Employee> employeeList = Stream.of(new Employee(121,"Mihir",89000),
            new Employee(124,"Pranav",56000.00),
            new Employee(145,"Tanish",44000),
            new Employee(149,"Sachin",12000)).toList();

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return new ResponseEntity<>(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName).reversed()).toList(),HttpStatus.OK);
    }

}
