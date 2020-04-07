package com.unthinkable.employeeManagement.api.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details of Department")
public class DepartmentDto {
    @ApiModelProperty(notes = "Unique Id")
    public String id;
    @ApiModelProperty(notes = "Name of Department")
    public String name;
    @ApiModelProperty(notes = "Info about Department")
    public String info;
}
