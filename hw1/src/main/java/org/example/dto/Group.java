package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Group {
    private long id;
    private String number;

    public Group(String number) {
        this.number = number;
    }
}
