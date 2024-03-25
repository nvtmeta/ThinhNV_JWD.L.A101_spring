package fsa.training.ThinhNV_JWD.L.A101.controller;


import fsa.training.ThinhNV_JWD.L.A101.model.dto.AccountAddDto;
import fsa.training.ThinhNV_JWD.L.A101.model.dto.EmployeeAddDto;
import fsa.training.ThinhNV_JWD.L.A101.model.entity.Account;
import fsa.training.ThinhNV_JWD.L.A101.model.entity.Employee;
import fsa.training.ThinhNV_JWD.L.A101.service.EmployeeService;
import fsa.training.ThinhNV_JWD.L.A101.util.ValidatePassword;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employee(Model model,
                           @RequestParam(name = "q", required = false) String query,
                           @RequestParam(name = "field", required = false) String searchField,
                           @PageableDefault(page = 0, size = 3) Pageable pageable
    ) {
//        TODO:when search, need pagination fix
        Page<Employee> employees;
        Specification<Employee> spec = Specification.where(null);

        Specification<Employee> specKeyword = (root, query1, criteriaBuilder) ->
                criteriaBuilder.like(root.get(searchField), "%" + query + "%");
        spec = spec.and(specKeyword);

        if(query != null) {
            employees = employeeService.getAllEmployees(spec, pageable);
        } else {
            employees = employeeService.getAllEmployees(pageable);
        }


        model.addAttribute("employees", employees);
        return "view/employee/list";
    }

    //    get detail employee
    @GetMapping("/employees/{employeeId}")
    public String employeeDetail(Model model, @PathVariable("employeeId") Integer employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        System.out.println("employee: " + employee);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "view/employee/detail";
        }
        model.addAttribute("error", "Employee not found");
        return "view/employee/list";
    }

    @GetMapping("/employees/create")
    public String createEmployee(Model model) {
        model.addAttribute("employeeFormData", new EmployeeAddDto());
        return "view/employee/form";
    }

    @PostMapping("/employees/create")
    public String createEmployee(@ModelAttribute("employeeFormData") @Valid EmployeeAddDto employeeAddDto,
                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "redirect:/employees/create?error=password";
        }

        boolean isValid = ValidatePassword.isValid(employeeAddDto.getAccount().getPassword());
        if (!isValid) {
//            bindingResult.rejectValue("password", "error.password", "Password must have at least 6 characters, including uppercase, lowercase,
//            and a number");
            return "redirect:/employees/create?error=password";
        }

        System.out.println("employeeAddDto: " + employeeAddDto.getAccount().getAccount());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeAddDto, employee);

        AccountAddDto account = employeeAddDto.getAccount();
        Account accountEntity = new Account();
        BeanUtils.copyProperties(account, accountEntity);
        employee.setAccount(accountEntity);
        accountEntity.setEmployee(employee);

        employeeService.createEmployee(employee);

        return "redirect:/employees?success=add";
    }

    @GetMapping("/employees/update")
    public String updateEmployee() {
        return "view/employee/form";
    }


    @GetMapping("/employees/delete/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        System.out.println("employeeId: " + employeeId);
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees?success=delete";
    }




}
