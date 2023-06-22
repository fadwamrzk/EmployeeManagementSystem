package com.example.employeemanager.service;
import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
//By using @Service, you provide a clear and concise way to communicate that the EmployeeService class performs
// business logic or acts as a service layer in the application.
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    //The @Autowired annotation is used for dependency injection.
    // It tells Spring to automatically wire (or inject) the required dependencies into the EmployeeService class.
    // In this case, the EmployeeRepo dependency is injected into the constructor of the EmployeeService class
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);

    }

    public List<Employee> findAllemployees()
    {
        return employeeRepo.findAll();
    }

    public Employee updateemployee(Employee employee)
    {
        return employeeRepo.save(employee);

    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }
    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }


}
