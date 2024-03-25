package fsa.training.ThinhNV_JWD.L.A101.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountAddDto {

    @UniqueElements(message = "Username already exists")
    private String account;

    @Email
    @UniqueElements(message = "Email already exists")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$",
            message = "Password must have at least 6 characters, including uppercase, lowercase, and a number")
    private String password;

    private Integer status;

}
