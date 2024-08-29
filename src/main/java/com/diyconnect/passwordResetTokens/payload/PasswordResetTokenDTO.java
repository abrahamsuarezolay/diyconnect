package com.diyconnect.passwordResetTokens.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordResetTokenDTO {
    String token;
}
