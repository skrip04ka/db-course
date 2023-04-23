package org.example.jdbs;

import org.example.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(JdbcStudentsRepository.class)
class JdbcStudentsRepositoryTest {

    int maxScore = 100;

    @Autowired
    private StudentsRepository repository;

    @Test
    void getAverageScoreByCourseIdAndGroupId() {


        Course testCourse = new Course("TestCourse");
        Group testGroup = new Group("TestGroup");

        repository.insertCourses(testCourse);
        repository.insertGroups(testGroup);

        Student testStudent = new Student("testStudent", testGroup.getId());
        repository.insertStudents(testStudent);

        repository.insertCoursesYears(new CoursesYear(testGroup.getId(), testCourse.getId(), "year"));

        double av = 0;
        for (int i = 1; i <= maxScore; i++) {
            repository.insertScores(new Score(testStudent.getId(),testCourse.getId(), i));
            av = av + i;
        }


        Optional<Double> result = repository.getAverageScoreByCourseNameAndGroupNumber(testCourse.getName(), testGroup.getNumber());
        assertTrue(result.isPresent());
        assertEquals(Math.round(av/maxScore * 100)/100.0, result.get());

    }
}