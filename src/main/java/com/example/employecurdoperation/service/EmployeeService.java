package com.example.employecurdoperation.service;

import com.example.employecurdoperation.Repository.EmployeeRepository;
import com.example.employecurdoperation.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeerepository;

    public Employee createemployee(Employee employee) {
        return employeerepository.save(employee);
    }

    public List<Employee> getallemployee() {
        return employeerepository.findAll();
    }

    public Optional<Employee> getbyid(Long id) {
        return employeerepository.findById(id);
    }


    public void deletebyid(Long id) {
        employeerepository.deleteById(id);
    }

    public Employee update(Long id, Employee employee) {
        employee.setId(id);

        if (employeerepository.existsById(id)) {
            return employeerepository.save(employee);

        }
        return null;

    }


}
