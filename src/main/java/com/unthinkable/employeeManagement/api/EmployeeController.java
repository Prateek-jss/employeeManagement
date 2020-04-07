package com.unthinkable.employeeManagement.api;

import com.unthinkable.employeeManagement.api.dto.EmployeeDto;
import com.unthinkable.employeeManagement.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/employees","/api/v1/employees"})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @GetMapping
    @ApiOperation(value = "Find all Employees"
            ,notes = "It will return the list of all employee"
            , response = EmployeeDto.class)
    public List<EmployeeDto> getAllEmployees() {
        logger.info("Getting all Employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Employee with given Id"
            , response = EmployeeDto.class)
    public EmployeeDto getEmployee(@PathVariable String id) {
        logger.info("Getting Employee with id : {}", ()-> id);
        return employeeService.getEmployee(id);
    }

    @PostMapping
    @ApiOperation(value = "Add Employee")
    public void addEmployee(@RequestBody EmployeeDto employeeDto) {
        logger.info("Adding a new Employee");
        employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Employee with given Id")
    public void updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable String id) {
        logger.info("Updating Employee with id : {}", ()-> id);
        employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Employee")
    public void deleteEmployee(@PathVariable String id) {
        logger.info("Deleting Employees with id : {}", ()-> id);
        employeeService.deleteEmployee(id);
    }

}
