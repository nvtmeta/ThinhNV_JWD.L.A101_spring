package fsa.training.ThinhNV_JWD.L.A101.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidatePassword {

    public static boolean isValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");
    }
}
