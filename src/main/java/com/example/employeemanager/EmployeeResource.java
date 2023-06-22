package com.example.employeemanager;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//When you annotate a class with @RestController, it indicates that the class will handle incoming HTTP requests
// and produce the response in a format suitable for RESTful web services, such as JSON or XML
@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //this method returns an http response, for that we use the class ReponseEntity
    //It maps a specific URL endpoint to the annotated method, and when a GET request is made to that endpoint, the method is executed
    @GetMapping("/all")
    //ResponseEntity is a class that represents the entire HTTP response, including the status code, headers, and response body. Here, the list of employees is set as the response body.
    public ResponseEntity<List<Employee>> getAllemployees() {
        List<Employee> employees = employeeService.findAllemployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);

        //In HTTP, each response has a status code that indicates the outcome of the request..
        // The HttpStatus.OK value is passed to the ResponseEntity constructor, indicating that the HTTP response status should be set to 200 OK.
        // 200 OK status indicates that the request was successful.
    }

    @GetMapping("/find/{id}")
    //ResponseEntity is a class that represents the entire HTTP response, including the status code, headers, and response body. Here, the list of employees is set as the response body.
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
        //CREATED means that we created something on the server
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}