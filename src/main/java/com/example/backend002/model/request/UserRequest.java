package com.example.backend002.model.request;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

//    @NotBlank(message = "Name cannot be blank")
//    @Pattern(regexp = "^[A-Z][a-z]*$", message = "Name must start with an uppercase letter and contain only letters")
    private String name;
//    @NotBlank(message = "Password cannot be blank")
//    @Size(min = 6, message = "Password must be at least 6 characters long")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]*$",
//            message = "Password must contain at least one uppercase letter and one digit")
    private String password;
//    @NotBlank(message = "Email cannot be blank")
//    @Email(message = "Email should be valid")
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email format is invalid. Please make sure to use uppercase letters and numbers.")
    private String email;
    private LibraryCreateRequest library;


}
