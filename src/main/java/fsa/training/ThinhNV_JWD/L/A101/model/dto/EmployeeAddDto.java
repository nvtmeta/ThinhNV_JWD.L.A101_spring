package fsa.training.ThinhNV_JWD.L.A101.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAddDto {
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;


    private String address;

    private Integer gender;

    @NotNull(message = "Phone number is required")
    private String phone;

    private AccountAddDto account;

    private String remark;

    private String departmentName;
}
