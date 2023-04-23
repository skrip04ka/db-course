package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoursesYear {
    private long id;
    private long groupId;
    private long coursesId;
    private String yearAdmission;

    public CoursesYear(long groupId, long coursesId, String yearAdmission) {
        this.groupId = groupId;
        this.coursesId = coursesId;
        this.yearAdmission = yearAdmission;
    }
}
