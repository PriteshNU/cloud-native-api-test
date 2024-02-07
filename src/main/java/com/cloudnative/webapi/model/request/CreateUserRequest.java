package com.cloudnative.webapi.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CreateUserRequest {
    @NotBlank
    @Email(message = "Invalid username")
    @JsonProperty("username")
    private String username;
    @NotBlank
    @JsonProperty("password")
    private String password;
    @NotBlank
    @JsonProperty("first_name")
    private String firstname;
    @NotBlank
    @JsonProperty("last_name")
    private String lastname;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }
}
