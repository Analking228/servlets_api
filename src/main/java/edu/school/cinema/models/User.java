package edu.school.cinema.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private int user_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
