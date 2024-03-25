package fsa.training.ThinhNV_JWD.L.A101.service;

import fsa.training.ThinhNV_JWD.L.A101.model.dto.EmployeeAddDto;
import fsa.training.ThinhNV_JWD.L.A101.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //    get all employees
    public Page<Employee> getAllEmployees(Specification<Employee> spec, Pageable pageable);
    public Page<Employee> getAllEmployees( Pageable pageable);


    //    get employee by id
    public Optional<Employee> getEmployeeById(Integer employeeId);

    public void createEmployee(Employee employee);


    public void updateEmployee(Employee employee);


    public void deleteEmployee(Integer employeeId);
}
