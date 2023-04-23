package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {
    private long id;
    private String name;

    public Course(String name) {
        this.name = name;
    }
}
