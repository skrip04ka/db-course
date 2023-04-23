package org.example.repositories;

import org.example.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import(StudentsRepositoryJpa.class)
class StudentsRepositoryJpaTest {

    @Autowired
    private StudentsRepositoryJpa repository;
    private int maxScore = 10;

    @Test
    void getAverageScoreByCourseIdAndGroupId() {

        Course testCourse = new Course("TestCourse");
        Group testGroup = new Group("TestGroup");

        repository.saveCourses(testCourse);
        repository.saveGroups(testGroup);

        Student testStudent = new Student("testStudent", testGroup);
        repository.saveStudents(testStudent);

        repository.saveCoursesYears(new CoursesYear(testGroup, testCourse, "year"));

        double av = 0;
        for (int i = 1; i <= maxScore; i++) {
            repository.saveScores(new Score(testStudent, testCourse, i));
            av = av + i;
        }

        Optional<Double> result = repository.getAverageScoreByCourseNameAndGroupNumber(testCourse.getName(), testGroup.getNumber());
        assertTrue(result.isPresent());
        assertEquals(Math.round(av/maxScore * 100)/100.0, result.get());
    }
}