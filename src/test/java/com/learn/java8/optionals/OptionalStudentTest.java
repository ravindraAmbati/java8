package com.learn.java8.optionals;

/* @author ravin @date 09-05-2020 @time 19:46 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class OptionalStudentTest {

    Function<List<String>, Optional<String>> optionalFunction = null;
    private List<Student> students = null;
    private Predicate<Student> maleStudentPredicate = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        maleStudentPredicate = s -> Objects.equals("MALE", s.getGender());
        optionalFunction = strings -> {
            StringBuffer str = new StringBuffer();
            strings.forEach(s -> str.append(s.toUpperCase()).append(" || "));
            return Optional.ofNullable(Objects.toString(str));
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        maleStudentPredicate = null;
        optionalFunction = null;
    }

    @Test
    void optionalStudentFilterTest() {
        students
                .stream()
                .findAny()
                .filter(maleStudentPredicate.negate())
                .ifPresent(
                        s ->
                                log.info(
                                        s.toString()
                                )
                );
    }

    @Test
    void optionalStudentMapTest() {
        students
                .stream()
                .findAny()
                .map(s -> maleStudentPredicate.negate().test(s) ? s.getName() : null)
                .ifPresent(
                        log::info
                );
    }

    @Test
    void optionalStudentFlatMapTest() {

        students
                .stream()
                .findAny()
                .map(s -> maleStudentPredicate.negate().test(s) ? s.getActivities() : null)
                .flatMap(optionalFunction)
                .ifPresent(
                        log::info
                );

        optionalFunction = a -> Optional.empty();

        students
                .stream()
                .findAny()
                .map(s -> maleStudentPredicate.negate().test(s) ? s.getActivities() : null)
                .flatMap(optionalFunction)
                .ifPresent(
                        log::info
                );
    }
}
