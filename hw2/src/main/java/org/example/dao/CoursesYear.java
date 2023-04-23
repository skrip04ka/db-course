package org.example.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "COURSES_YEAR")
@NoArgsConstructor
public class CoursesYear {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "YEAR_ADMISSION")
    private String yearAdmission;
    @ManyToOne(targetEntity = Group.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private Group group;
    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
    private Course course;

    public CoursesYear(Group group, Course course, String yearAdmission) {
        this.group = group;
        this.course = course;
        this.yearAdmission = yearAdmission;
    }
}
