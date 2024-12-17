package com.example.employecurdoperation.controller;

import com.example.employecurdoperation.entity.Employee;
import com.example.employecurdoperation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @GetMapping("/read")
    public List<Employee> getallemployee(){
        return employeeservice.getallemployee();

    }
    @PostMapping("/save")
    public ResponseEntity<Employee> createemployee(@RequestBody Employee e){
        Employee employee = employeeservice.createemployee(e);

        return  new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("read/{id}")
    public Employee getbyid(@PathVariable Long id) {
        return employeeservice.getbyid(id).orElse(null);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
          employeeservice.deletebyid(id);
            // Return 204 No Content if deletion is successful
            return ResponseEntity.noContent().build();
        }
        @PutMapping("update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, Employee employee){
        Employee updated = employeeservice.update(id,employee);
        return ResponseEntity.ok(updated);
        }

}


