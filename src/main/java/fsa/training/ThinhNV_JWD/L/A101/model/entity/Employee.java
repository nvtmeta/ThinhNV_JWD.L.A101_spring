package fsa.training.ThinhNV_JWD.L.A101.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", columnDefinition = "int")
    private Integer employeeId;

    //    first_name varchar(255)
    @Column(name = "first_name", columnDefinition = "varchar(255)", nullable = false)
    private String firstName;

    @Column(name = "last_name", columnDefinition = "varchar(255)", nullable = false)
    private String lastName;


    @Column(name = "gender", columnDefinition = "int")
    private Integer gender;

    @Column(name = "date_of_birth", columnDefinition = "date")
    private LocalDate dateOfBirth;

    @Column(name = "phone", columnDefinition = "varchar(20)")
    private String phone;

    @Column(name = "address", columnDefinition = "varchar(255)", nullable = false)
    private String address;

    @Column(name = "department_name", columnDefinition = "varchar(255)")
    private String departmentName;

    @Column(name = "remark", columnDefinition = "varchar(1000)", nullable = false)
    private String remark;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Account account;

}
