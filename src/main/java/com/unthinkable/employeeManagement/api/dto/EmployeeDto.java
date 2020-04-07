package com.unthinkable.employeeManagement.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Detail about Employee")
public class EmployeeDto {
    @ApiModelProperty(notes = "Unique ID")
    private String id;
    @ApiModelProperty(notes = "First Name of Employee")
    private String firstName;
    @ApiModelProperty(notes = "Last Name of Employee")
    private String lastName;
    @ApiModelProperty(notes = "List of Deparment Ids in which Employee works")
    private List<String> departmentIds;
}
