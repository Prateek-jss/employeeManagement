package com.unthinkable.employeeManagement.api.data.repository;

import com.unthinkable.employeeManagement.api.data.model.Department;
import com.unthinkable.employeeManagement.api.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
