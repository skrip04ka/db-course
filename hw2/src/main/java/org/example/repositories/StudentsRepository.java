package org.example.repositories;

import org.example.dao.*;

import java.util.Optional;

public interface StudentsRepository {

    void saveStudents(Student... students);

    void saveGroups(Group... groups);

    void saveScores(Score... scores);

    void saveCourses(Course... courses);

    void saveCoursesYears(CoursesYear... coursesYears);

    Optional<Double> getAverageScoreByCourseNameAndGroupNumber(String courseName, String groupNumber);


}
