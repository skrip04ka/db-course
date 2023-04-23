package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Score {
    private long id;
    private long studentId;
    private long coursesId;
    private int score;

    public Score(long studentId, long coursesId, int score) {
        this.studentId = studentId;
        this.coursesId = coursesId;
        this.score = score;
    }
}
