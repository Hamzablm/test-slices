package com.demo.testslices.restClientTest;

import com.demo.testslices.Employee;
import lombok.Data;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeDetailsService {

    private final RestTemplate restTemplate;

    public EmployeeDetailsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public EmployeeDetails getEmployeeDetails(int id) {
        return restTemplate.getForObject("http://localhost:8081/{id}/details", EmployeeDetails.class, id);
    }
}