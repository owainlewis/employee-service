package com.owainlewis.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class Employee {
    @JsonProperty
    private long id;

    @JsonProperty
    @NotNull
    private String firstName;

    @JsonProperty
    @NotNull
    private String lastName;

    @JsonProperty
    @NotNull
    private String email;

    @JsonProperty
    @NotNull
    private String title;

    public Employee () {
    }

    public Employee(@NotNull long id, @NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String title) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
