package com.diyconnect.passwordResetTokens.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetRequest {

    String email;
    String password;
    String confirmPassword;
    String token;
}
