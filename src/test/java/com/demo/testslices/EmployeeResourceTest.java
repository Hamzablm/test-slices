package com.demo.testslices;

import com.demo.testslices.webMvcTest.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest
public class EmployeeResourceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    List<Employee> employees = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("a first name");
        employee.setLastName("a last name");
        employees.add(employee);
    }

    @Test
    public void shouldReturnOkayAndPayloadWhenRequestingEmployeeResource() throws Exception {
        Mockito.doReturn(employees).when(employeeService).getAllEmployees();
        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0]firstName").value("a first name"))
                .andExpect(jsonPath("$[0]lastName").value("a last name"));
    }
}
