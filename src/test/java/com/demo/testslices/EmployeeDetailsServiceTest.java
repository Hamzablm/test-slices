package com.demo.testslices;

import com.demo.testslices.restClientTest.EmployeeDetails;
import com.demo.testslices.restClientTest.EmployeeDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(EmployeeDetailsService.class)
public class EmployeeDetailsServiceTest {

    @Autowired
    private EmployeeDetailsService employeeDetailsService;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    public void shouldReturnEmployeeDetailsFromHttpRequest() {
        mockRestServiceServer.expect(requestTo("http://localhost:8081/1/details")).andRespond(
                withSuccess(new ClassPathResource("employeeDetails.json"), MediaType.APPLICATION_JSON));

        EmployeeDetails employeeDetails = employeeDetailsService.getEmployeeDetails(1);

        assertThat(employeeDetails.getAddress()).isEqualTo("Morocco, Casablanca, Maarif");
        assertThat(employeeDetails.getSalary()).isEqualTo(100_000);
    }
}
