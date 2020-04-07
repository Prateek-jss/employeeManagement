package com.unthinkable.employeeManagement.api.data.model;

import com.unthinkable.employeeManagement.Auditing.Auditable;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department extends Auditable<String> {
    @Id
    private String id;
    private String name;
    private String info;
    @ManyToMany(mappedBy = "departments",cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department(String departmentId){
        this.id = departmentId;
    }


}
