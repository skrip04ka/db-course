package org.example.jdbs;

import org.example.dto.*;

import java.util.Optional;

public interface StudentsRepository {

    void insertStudents(Student... students);

    void insertGroups(Group... groups);

    void insertScores(Score... scores);

    void insertCourses(Course... courses);

    void insertCoursesYears(CoursesYear... coursesYears);

    Optional<Double> getAverageScoreByCourseNameAndGroupNumber(String courseName, String groupNumber);


}
