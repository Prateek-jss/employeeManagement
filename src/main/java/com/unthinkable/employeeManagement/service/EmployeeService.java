package com.unthinkable.employeeManagement.service;

import com.unthinkable.employeeManagement.api.data.model.Department;
import com.unthinkable.employeeManagement.api.data.model.Employee;
import com.unthinkable.employeeManagement.api.data.repository.EmployeeRepository;
import com.unthinkable.employeeManagement.api.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public EmployeeDto getEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        List<String> ids = employee.getDepartments().stream()
                .map(department -> department.getId()).collect(Collectors.toList());
         EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
         employeeDto.setDepartmentIds(ids);
         return employeeDto;
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee ->  modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        }

    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setDepartments(employeeDto.getDepartmentIds().stream()
                .map(departmentId -> new Department(departmentId))
                .collect(Collectors.toList()));
        employeeRepository.save(employee);
    }

    public void updateEmployee(String id, EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
