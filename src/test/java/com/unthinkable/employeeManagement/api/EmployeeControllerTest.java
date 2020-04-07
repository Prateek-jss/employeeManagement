package com.unthinkable.employeeManagement.api;

import com.unthinkable.employeeManagement.api.data.model.Employee;
import com.unthinkable.employeeManagement.api.data.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllEmployees() {
        Employee emloyee1 = new Employee("1", "Prateek"
                , "Chaudhary", null);
        Employee emloyee2 = new Employee("2", "Anubhav"
                , "Tyagi", null);

        List<Employee> list = new ArrayList<Employee>();
        list.addAll(Arrays.asList(emloyee1, emloyee2));
        when(employeeRepository.findAll()).thenReturn(list);
        List<Employee> result = employeeRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getId())
                .isEqualTo(emloyee1.getId());
        assertThat(result.get(1).getFirstName())
                .isEqualTo(emloyee2.getFirstName());
        assertNotNull(result);
    }

    @Test
    void getEmployee() {
        Employee employee = new Employee("1", "Prateek"
                , "Chaudhary", null);
        when(employeeRepository.findById("1")).thenReturn(Optional.of(employee));
        Employee result = employeeRepository.findById("1")
                .orElseThrow(() -> new RuntimeException("not found"));

        assertThat(result.getId()).isEqualTo("1");
        assertNotNull(result);
    }

    @Test
    void addEmployee() {
        Employee employee = new Employee();
        employee.setId("1");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee employeeToAdd = new Employee("1", "Prateek"
                , "Chaudhary", null);
        Employee result = employeeRepository.save(employeeToAdd);

        assertThat(result.getId()).isEqualTo("1");
        assertNotNull(result);
    }

    @Test
    void deleteEmployee() {
    }
}