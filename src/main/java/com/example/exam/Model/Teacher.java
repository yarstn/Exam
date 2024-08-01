package com.example.exam.Model;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "id cannot be null")
    @Size(min = 2, max = 5, message = "id min size is 2 and max 5")
    private int id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 15, message = "name min size is 5 and max 15")
    private String name;
    @NotNull(message = "salary cannot be null")
    private int salary;
}
