package org.example.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import org.example.dao.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class StudentsRepositoryJpa implements StudentsRepository {

    @PersistenceContext
    private EntityManager em;


    @PostConstruct
    private void init() {
        em.setFlushMode(FlushModeType.COMMIT);
    }


    @Override
    @Transactional
    public void saveStudents(Student... students) {
        for (Student student : students) {
            if (student.getId() <= 0) {
                em.persist(student);
            } else {
                em.merge(student);
            }
        }
        em.flush();
    }


    @Override
    @Transactional
    public void saveGroups(Group... groups) {
        for (Group group : groups) {
            if (group.getId() <= 0) {
                em.persist(group);
            } else {
                em.merge(group);
            }
        }
        em.flush();
    }

    @Override
    @Transactional
    public void saveScores(Score... scores) {
        for (Score score : scores) {
            if (score.getId() <= 0) {
                em.persist(score);
            } else {
                em.merge(score);
            }
        }
        em.flush();
    }

    @Override
    @Transactional
    public void saveCourses(Course... courses) {
        for (Course course : courses) {
            if (course.getId() <= 0) {
                em.persist(course);
            } else {
                em.merge(course);
            }
        }
        em.flush();
    }

    @Override
    @Transactional
    public void saveCoursesYears(CoursesYear... coursesYears) {
        for (CoursesYear coursesYear : coursesYears) {
            if (coursesYear.getId() <= 0) {
                em.persist(coursesYear);
            } else {
                em.merge(coursesYear);
            }
        }
        em.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Double> getAverageScoreByCourseNameAndGroupNumber(String courseName, String groupNumber) {
        return Optional.ofNullable(em.createQuery(
                        "select round(cast(sum(s.score) as double) / count(s.score), 2) from Score s " + // cast() - ложно положительная ошибка, в @Query() анализируется правильно
                                "join Course c on c = s.course " +
                                "join Student st on st = s.student " +
                                "join Group g on g = st.group " +
                                "where c.name like :courseName and g.number like :groupNumber ",
                        Double.class)
                .setParameter("courseName", courseName)
                .setParameter("groupNumber", groupNumber)
                .getSingleResult());
    }
}
