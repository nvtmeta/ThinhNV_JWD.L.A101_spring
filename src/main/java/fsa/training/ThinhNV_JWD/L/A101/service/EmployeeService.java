package fsa.training.ThinhNV_JWD.L.A101.service;

import fsa.training.ThinhNV_JWD.L.A101.model.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //    get all employees
    public List<Employee> getAllEmployees();


    //    get employee by id
    public Optional<Employee> getEmployeeById(Integer employeeId);

    public void createEmployee(Employee employee);


    public void updateEmployee(Employee employee);


    public void deleteEmployee(Integer employeeId);
}
