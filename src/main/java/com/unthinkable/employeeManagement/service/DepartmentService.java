package com.unthinkable.employeeManagement.service;

import com.unthinkable.employeeManagement.api.data.model.Department;
import com.unthinkable.employeeManagement.api.data.repository.DepartmentRepository;
import com.unthinkable.employeeManagement.api.dto.DepartmentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    ModelMapper modelMapper = new ModelMapper();

    public DepartmentDto getDepartment(String id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return modelMapper.map(department, DepartmentDto.class);
    }

    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments;
         departments = departmentRepository.findAll();
         return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDto.class))
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> addDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        departmentRepository.save(department);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> updateDepartment(String id, DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        departmentRepository.save(department);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> deleteDepartment(String id) {
        departmentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
