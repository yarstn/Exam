package com.example.exam.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "id cannot be empty")
    @Size(min = 2, max = 5, message = "id min size is 2 and max 5")
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 15, message = "name min size is 5 and max 15")
    private String name;
    @NotNull(message = "age cannot be empty")
    @Min(value = 6, message = "minimum age is 6")
    @Max(value = 18, message = "maximum age is 18")
    private int age;
    @NotEmpty(message = "major cannot be empty")
    private String major;
}
