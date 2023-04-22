package org.example.jdbs;

import org.example.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

@Repository
public class JdbcStudentsRepository implements StudentsRepository {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;
    private final KeyHolder holder = new GeneratedKeyHolder();

    @Autowired
    public JdbcStudentsRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    @Override
    public void insertStudents(Student... students) {
        for (Student student : students) {
            namedParameterJdbcOperations.update(
                    "insert into STUDENTS (NAME, GROUP_ID) values (:name, :groupId)",
                    new MapSqlParameterSource()
                            .addValue("name", student.getName())
                            .addValue("groupId", student.getGroupId()),
                    holder);
            student.setId(Objects.requireNonNull(holder.getKey()).longValue());
        }
    }

    @Override
    public void insertGroups(Group... groups) {
        for (Group group : groups) {
            namedParameterJdbcOperations.update(
                    "insert into GROUPS (NUMBER) values (:number)",
                    new MapSqlParameterSource()
                            .addValue("number", group.getNumber()),
                    holder);
            group.setId(Objects.requireNonNull(holder.getKey()).longValue());
        }
    }

    @Override
    public void insertScores(Score... scores) {
        for (Score score : scores) {
            namedParameterJdbcOperations.update(
                    "insert into SCORES (STUDENT_ID, COURSE_ID, SCORE) values (:student, :course, :score)",
                    new MapSqlParameterSource()
                            .addValue("student", score.getStudentId())
                            .addValue("course", score.getCoursesId())
                            .addValue("score", score.getScore()),
                    holder);
            score.setId(Objects.requireNonNull(holder.getKey()).longValue());
        }
    }

    @Override
    public void insertCourses(Course... courses) {
        for (Course course : courses) {
            namedParameterJdbcOperations.update(
                    "insert into COURSES (NAME) values (:name)",
                    new MapSqlParameterSource()
                            .addValue("name", course.getName()),
                    holder);
            course.setId(Objects.requireNonNull(holder.getKey()).longValue());
        }
    }

    @Override
    public void insertCoursesYears(CoursesYear... coursesYears) {
        for (CoursesYear coursesYear : coursesYears) {
            namedParameterJdbcOperations.update(
                    "insert into COURSES_YEAR (GROUP_ID, COURSE_ID, YEAR_ADMISSION) values (:groupId, :coursesId, :year)",
                    new MapSqlParameterSource()
                            .addValue("groupId", coursesYear.getGroupId())
                            .addValue("coursesId", coursesYear.getCoursesId())
                            .addValue("year", coursesYear.getYearAdmission()),
                    holder);
            coursesYear.setId(Objects.requireNonNull(holder.getKey()).longValue());
        }
    }

    @Override
    public Optional<Double> getAverageScoreByCourseNameAndGroupNumber(String courseName, String groupNumber) {

        return Optional.ofNullable(namedParameterJdbcOperations.queryForObject(
                "select round(cast(SUM(SCORES.score) as float)/COUNT(SCORES.score), 2) " +
                        "from SCORES " +
                        "   join COURSES on COURSES.ID = SCORES.COURSE_ID " +
                        "   join STUDENTS on STUDENTS.ID = SCORES.STUDENT_ID " +
                        "   join GROUPS on GROUPS.ID = STUDENTS.GROUP_ID " +
                        "where GROUPS.NUMBER like :groupNumber and COURSES.NAME like :courseName",
                new MapSqlParameterSource()
                        .addValue("courseName", courseName)
                        .addValue("groupNumber", groupNumber),
                double.class));

    }
}
