package com.demo.testslices.webMvcTest;

import com.demo.testslices.DataJpaTest.EmployeeRepository;
import com.demo.testslices.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
