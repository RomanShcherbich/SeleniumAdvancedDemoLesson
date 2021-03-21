package model;

import lombok.*;

import java.lang.reflect.Method;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@With
public class User {

    private String username;
    private String firstName;
    private String lastName;

    public User withUsername(@NonNull String username) {
        this.username = username;
        return this;
    }

}
