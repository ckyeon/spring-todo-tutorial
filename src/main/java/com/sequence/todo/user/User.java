package com.sequence.todo.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotNull
    @NotEmpty
    private String name;

    private String description;

    public User(String email, String name, String description) {
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public void update(String email, String name, String description) {
        if (email != null) {
            this.email = email;
        }

        if (name != null) {
            this.name = name;
        }

        if (description != null) {
            this.description = description;
        }
    }
}
