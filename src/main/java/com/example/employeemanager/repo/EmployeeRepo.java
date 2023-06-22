package com.example.employeemanager.repo;

import com.example.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository is part of the Spring Data JPA framework. The reason for extending the JpaRepository interface in the EmployeeRepo interface is to inherit and leverage
// the predefined CRUD (Create, Read, Update, Delete) operations and additional database query methods provided by JpaRepository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //those methods are "query methods" , In Spring Data, query methods refer to a feature provided by the Spring Data JPA framework that allows you to define database queries using method names in your repository interfaces.
    // These method names are parsed by the framework, and the corresponding SQL queries are automatically generated and executed for you.
    //for example Spring will understand that deleteEmployeeById will delete the employee corresponding to the id provided
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
