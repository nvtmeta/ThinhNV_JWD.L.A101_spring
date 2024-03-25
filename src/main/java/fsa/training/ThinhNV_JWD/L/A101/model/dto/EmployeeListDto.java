package fsa.training.ThinhNV_JWD.L.A101.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class EmployeeListDto {
    private Integer id;

    private String firstName;

    private LocalDate dateOfBirth;

    private String address;

    private String phone;

    private String departmentName;

}
