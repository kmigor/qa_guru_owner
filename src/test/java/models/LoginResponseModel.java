package models;

import lombok.Data;

@Data
public class LoginResponseModel {
    String userId;
    String username;
    String password;
    String token;
    String expires;
    String created_date;
    Boolean isActive;
}