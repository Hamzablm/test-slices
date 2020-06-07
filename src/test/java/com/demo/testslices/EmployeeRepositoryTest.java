package com.demo.testslices;

import com.demo.testslices.DataJpaTest.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TestEntityManager entityManager;

    Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee();
        employee.setId(1);
        employee.setFirstName("a first name");
        employee.setLastName("a last name");
    }

    @Test
    public void shouldSaveEmployee() {
        entityManager.persist(employee);
        Employee result = employeeRepository.findAll().get(0);
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getFirstName()).isEqualTo("a first name");
        assertThat(result.getLastName()).isEqualTo("a last name");
    }
}
