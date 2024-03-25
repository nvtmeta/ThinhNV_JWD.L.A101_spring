package fsa.training.ThinhNV_JWD.L.A101.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {


    @GetMapping("/employees")
    public String employee() {
        return "view/employee/list";
    }


    @GetMapping("/employees/create")
    public String createEmployee() {
        return "view/employee/create";
    }


    @GetMapping("/employees/update")
    public String updateEmployee() {
        return "view/employee/update";
    }

}
