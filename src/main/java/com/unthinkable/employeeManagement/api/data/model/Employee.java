package com.unthinkable.employeeManagement.api.data.model;

import com.unthinkable.employeeManagement.Auditing.Auditable;
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
public class Employee extends Auditable<String> {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @ManyToMany
    private List<Department> departments;
}
