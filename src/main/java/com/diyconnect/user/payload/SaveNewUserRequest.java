package com.diyconnect.user.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveNewUserRequest {
    private String username;
    private String email;
    private String password;
    private boolean admin;

}
