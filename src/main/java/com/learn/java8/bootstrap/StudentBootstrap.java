package com.learn.java8.bootstrap;

import com.learn.java8.models.Student;

import java.util.Arrays;
import java.util.List;

public class StudentBootstrap {

    public static List<Student> getStudents() {

        Student s1 = Student.builder().name("Leo").gender("Male").grade(1).gpa(8.0d).activities(Arrays.asList("singing", "aerobics", "cooking")).build();
        Student s2 = Student.builder().name("Neo").gender("Female").grade(1).gpa(7.3d).activities(Arrays.asList("cycling", "basketball", "soccer")).build();
        Student s3 = Student.builder().name("Intell").gender("Male").grade(2).gpa(8.1d).activities(Arrays.asList("soccer", "swimming", "singing")).build();
        Student s4 = Student.builder().name("Jack").gender("Female").grade(2).gpa(9.0d).activities(Arrays.asList("running", "basketball", "crafting")).build();
        Student s5 = Student.builder().name("Tech").gender("Male").grade(3).gpa(6.1d).activities(Arrays.asList("soccer", "cycling", "swimming")).build();
        Student s6 = Student.builder().name("Log").gender("Female").grade(3).gpa(5.9d).activities(Arrays.asList("swimming", "dancing", "crafting")).build();
        Student s7 = Student.builder().name("Novo").gender("Male").grade(4).gpa(7.0d).activities(Arrays.asList("singing", "running", "swimming")).build();
        Student s8 = Student.builder().name("Ipho").gender("Female").grade(4).gpa(8.0d).activities(Arrays.asList("cycling", "basketball", "running")).build();
        Student s9 = Student.builder().name("Mac").gender("Male").grade(5).gpa(7.5d).activities(Arrays.asList("soccer", "crafting", "cooking")).build();
        Student s0 = Student.builder().name("Cisco").gender("Female").grade(5).gpa(8.0d).activities(Arrays.asList("crafting", "aerobics", "cooking")).build();
        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s0);
    }
}
