package com.employeesystem.services;

import com.employeesystem.entity.Employee;
import com.employeesystem.model.EmployeeModel;
import com.employeesystem.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeEntity = new Employee();

        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<EmployeeModel> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeModel> employeeModels = employees.stream().map(employee -> new EmployeeModel(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail())).toList();
        return employeeModels;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public EmployeeModel getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employee,employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel editEmployee(Long id, EmployeeModel employeeModel) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setEmail(employeeModel.getEmail());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());

        employeeRepository.save(employee);
        return employeeModel;
    }
}
