package com.unthinkable.employeeManagement.api;

import com.unthinkable.employeeManagement.api.data.model.Department;
import com.unthinkable.employeeManagement.api.data.repository.DepartmentRepository;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DepartmentControllerTest {
    @InjectMocks
    DepartmentController departmentController;

    @Mock
    DepartmentRepository departmentRepository;
    private MockMvc mockMvc;

    @Test
    void getAllDepartments() {

        Department department1 = new Department("CS", "Computer Science"
                , "Best", null);
        Department department2 = new Department("EC", "Electronics"
                , "Average", null);

        List<Department> list = new ArrayList<Department>();
        list.addAll(Arrays.asList(department1, department2));
        when(departmentRepository.findAll()).thenReturn(list);

        List<Department> result = departmentRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getId())
                .isEqualTo(department1.getId());
        assertThat(result.get(1).getName())
                .isEqualTo(department2.getName());
        assertNotNull(result);
    }

    @Test
    void getDepartment() {
        Department department = new Department("CS", "Computer Science"
                , "Best", null);
        when(departmentRepository.findById("CS")).thenReturn(Optional.of(department));
        Department result = departmentRepository.findById("CS")
                .orElseThrow(() -> new RuntimeException("not found"));

        assertThat(result.getId()).isEqualTo("CS");
        assertNotNull(result);

    }

    @Test
    void addDepartment() throws Exception {
        Department department = new Department();
        department.setId("CS");
        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Department departmentToAdd = new Department("CS"
                , "Computer Science", "Best", null);
        Department result = departmentRepository.save(departmentToAdd);

        assertThat(result.getId()).isEqualTo("CS");
        assertNotNull(result);

    }

    @Test
    void deleteDepartment() {

    }

}