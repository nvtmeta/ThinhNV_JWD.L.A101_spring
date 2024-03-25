package fsa.training.ThinhNV_JWD.L.A101.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", columnDefinition = "int")
    private Integer id;

    @Column(name = "account", columnDefinition = "varchar(255)", unique = true)
    private String account;

    @Column(name = "email", columnDefinition = "varchar(255)", unique = true)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(255)")
    private String password;

    @Column(name = "status", columnDefinition = "int", nullable = false)
    private Integer status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Employeeemployee_id")
    @ToString.Exclude
    private Employee employee;

}
