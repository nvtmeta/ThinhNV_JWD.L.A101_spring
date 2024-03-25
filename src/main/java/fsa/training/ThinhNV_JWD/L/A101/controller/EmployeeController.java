package fsa.training.ThinhNV_JWD.L.A101.controller;


import fsa.training.ThinhNV_JWD.L.A101.model.entity.Employee;
import fsa.training.ThinhNV_JWD.L.A101.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employee(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();

        model.addAttribute("employees", employees);
        return "view/employee/list";
    }


    @GetMapping("/employees/create")
    public String createEmployee() {
        return "view/employee/add";
    }


    @GetMapping("/employees/update")
    public String updateEmployee() {
        return "view/employee/update";
    }

}
