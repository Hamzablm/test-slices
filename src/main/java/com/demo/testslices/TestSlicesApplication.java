package com.demo.testslices;

import com.demo.testslices.DataJpaTest.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@SpringBootApplication
public class TestSlicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSlicesApplication.class, args);
    }

}

