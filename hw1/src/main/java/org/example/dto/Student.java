package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private long id;
    private String name;
    private long groupId;

    public Student(String name, long groupId) {
        this.name = name;
        this.groupId = groupId;
    }
}
