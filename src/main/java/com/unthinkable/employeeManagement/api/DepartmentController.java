package com.unthinkable.employeeManagement.api;

import com.unthinkable.employeeManagement.api.dto.DepartmentDto;
import com.unthinkable.employeeManagement.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/departments","/api/v1/departments"})
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    private static final Logger logger = LogManager.getLogger(DepartmentController.class);

    @GetMapping
    @ApiOperation(value = "Find all Departments"
            ,notes = "It will return the list of all department"
            , response = DepartmentDto.class)
    public List<DepartmentDto> getAllDepartments() {
        logger.info("Getting all Departments");
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Department by Id"
            ,notes = "It will return department with given Id"
            , response = DepartmentDto.class)
    public DepartmentDto getDepartment(@PathVariable String id) {
        logger.info("Getting Department with id : {}", ()-> id);
        return departmentService.getDepartment(id);
    }

    @PostMapping
    @ApiOperation(value = "Add Department")
    public ResponseEntity<Object> addDepartment(@RequestBody DepartmentDto departmentDto) {
        logger.info("Adding Department");
        return departmentService.addDepartment(departmentDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Department"
            ,notes = "It will update department of given ID" )
    public ResponseEntity<Object> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable String id) {
        logger.info("Updating Department with id : {}", ()-> id);
        return departmentService.updateDepartment(id, departmentDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Department")
    public ResponseEntity<Object> deleteDepartment(@PathVariable String id) {
        logger.info("Deleting Department with id : {}", ()-> id);
        return departmentService.deleteDepartment(id);
    }

}
