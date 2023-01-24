package com.employeesystem.services;

import com.employeesystem.entity.Employee;
import com.employeesystem.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<EmployeeModel> getEmployees();

    boolean deleteEmployee(Long id);

    EmployeeModel getEmployeeById(Long id);

    EmployeeModel editEmployee(Long id, EmployeeModel employeeModel);
}
