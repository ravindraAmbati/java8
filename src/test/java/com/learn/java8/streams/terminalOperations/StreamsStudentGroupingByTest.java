package com.learn.java8.streams.terminalOperations;

/* @author ravin @date 09-05-2020 @time 11:40 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

@Slf4j
public class StreamsStudentGroupingByTest {

    private static final String O = "OUTSTANDING";
    private static final String A = "AVERAGE";
    private List<Student> students = null;
    private Map<String, List<Student>> studentsMapGroupedByGender = null;
    private Map<Integer, List<Student>> studentsMapGroupedByGrade = null;
    private Map<Double, List<Student>> studentsMapGroupedByGpa = null;
    private Map<String, List<Student>> studentsMapGroupedByGpaOutstandingAverage = null;
    private Map<String, Map<String, List<Student>>> studentsMapTwoLevelGroupedByGenderGpaOutstandingAverage = null;
    private Map<Integer, Map<String, List<Student>>> studentsMapTwoLevelGroupedByGradeGpaOutstandingAverage = null;
    private Map<String, Double> studentsMapTwoLevelGroupedByGenderSummingGpa = null;
    private Map<Integer, Double> studentsMapTwoLevelGroupedByGradeSummingGpa = null;
    private Map<String, Double> studentsMapTwoLevelGroupedByGenderAverageGpa = null;
    private Map<Integer, Double> studentsMapTwoLevelGroupedByGradeAverageGpa = null;
    private Comparator<Student> gpaComparator = null;

    @BeforeEach
    void setUp() {

        students = StudentBootstrap.getStudents();
        studentsMapGroupedByGender = null;
        studentsMapGroupedByGrade = null;
        studentsMapGroupedByGpa = null;
        studentsMapGroupedByGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGenderGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGradeGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGenderSummingGpa = null;
        studentsMapTwoLevelGroupedByGradeSummingGpa = null;
        studentsMapTwoLevelGroupedByGenderAverageGpa = null;
        studentsMapTwoLevelGroupedByGradeAverageGpa = null;
        gpaComparator = Comparator.comparing(Student::getGpa);
    }

    @AfterEach
    void tearDown() {

        students = null;
        studentsMapGroupedByGender = null;
        studentsMapGroupedByGrade = null;
        studentsMapGroupedByGpa = null;
        studentsMapGroupedByGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGenderGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGradeGpaOutstandingAverage = null;
        studentsMapTwoLevelGroupedByGenderSummingGpa = null;
        studentsMapTwoLevelGroupedByGradeSummingGpa = null;
        studentsMapTwoLevelGroupedByGenderAverageGpa = null;
        studentsMapTwoLevelGroupedByGradeAverageGpa = null;
        gpaComparator = null;
    }

    @Test
    void groupStudentsByGenderTest() {
        studentsMapGroupedByGender = students
                .stream()
                .collect(groupingBy(Student::getGender)
                );
        log.info(
                students
                        .stream()
                        .collect(groupingBy(Student::getGender))
                        .toString()
        );
    }

    @Test
    void groupStudentsByGradeTest() {
        studentsMapGroupedByGrade = students
                .stream()
                .collect(groupingBy(Student::getGrade)
                );
        log.info(
                students
                        .stream()
                        .collect(groupingBy(Student::getGrade))
                        .toString()
        );
    }

    @Test
    void groupStudentsByGpaTest() {
        studentsMapGroupedByGpa = students
                .stream()
                .collect(groupingBy(Student::getGpa)
                );
        log.info(
                students
                        .stream()
                        .collect(groupingBy(Student::getGpa))
                        .toString()
        );
    }

    @Test
    void groupStudentsByGpaOutstandingAverageTest() {
        studentsMapGroupedByGpaOutstandingAverage = students
                .stream()
                .collect(groupingBy(s -> s.getGpa() > 7.4d ? O : A)
                );
        log.info(
                students
                        .stream()
                        .collect(groupingBy(s -> s.getGpa() > 7.4d ? O : A))
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderGpaOutstandingAverageTest() {
        studentsMapTwoLevelGroupedByGenderGpaOutstandingAverage = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGender,
                                groupingBy(
                                        s -> s.getGpa() > 7.4d ? O : A)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        groupingBy(s -> s.getGpa() > 7.4d ? O : A)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeGpaOutstandingAverageTest() {
        studentsMapTwoLevelGroupedByGradeGpaOutstandingAverage = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGrade,
                                groupingBy(
                                        s -> s.getGpa() > 7.4d ? O : A)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        groupingBy(s -> s.getGpa() > 7.4d ? O : A)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderSummingGpaTest() {
        studentsMapTwoLevelGroupedByGenderSummingGpa = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGender,
                                summingDouble(Student::getGpa)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        summingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeSummingGpaTest() {
        studentsMapTwoLevelGroupedByGradeSummingGpa = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGrade,
                                summingDouble(Student::getGpa)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        summingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderAverageGpaTest() {
        studentsMapTwoLevelGroupedByGenderAverageGpa = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGender,
                                averagingDouble(Student::getGpa)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        averagingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeAverageGpaTest() {
        studentsMapTwoLevelGroupedByGradeAverageGpa = students
                .stream()
                .collect(
                        groupingBy(
                                Student::getGrade,
                                averagingDouble(Student::getGpa)
                        )
                );
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        averagingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderGpaOutstandingAverageHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        HashMap::new,
                                        groupingBy(s -> s.getGpa() > 7.4d ? O : A)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeGpaOutstandingAverageHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        HashMap::new,
                                        groupingBy(s -> s.getGpa() > 7.4d ? O : A)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderSummingGpaHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        HashMap::new,
                                        summingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeSummingGpaHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        HashMap::new,
                                        summingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderAverageGpaHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        HashMap::new,
                                        averagingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeAverageGpaHashMapTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        HashMap::new,
                                        averagingDouble(Student::getGpa)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeMaxByTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        maxBy(gpaComparator))
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderMaxByTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        maxBy(gpaComparator))
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGradeMinByTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGrade,
                                        minBy(gpaComparator))
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderMinByTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        minBy(gpaComparator))
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderMinByGpaCollectThenTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        collectingAndThen(
                                                minBy(gpaComparator),
                                                Optional::get)
                                )
                        )
                        .toString()
        );
    }

    @Test
    void groupStudentsTwoLevelByGenderMaxByGpaCollectThenTest() {
        log.info(
                students
                        .stream()
                        .collect(
                                groupingBy(
                                        Student::getGender,
                                        collectingAndThen(
                                                maxBy(gpaComparator),
                                                o -> o.orElseGet(Student::new)
                                        )
                                )
                        )
                        .toString()
        );
    }
}
