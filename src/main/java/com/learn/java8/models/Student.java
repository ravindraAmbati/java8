package com.learn.java8.models;

/* @author ravin @date 02-05-2020 @time 15:56 */

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Student {

    private String name;
    private String gender;
    private int grade;
    private double gpa;
    private List<String> activities = new ArrayList<>();

    @Builder
    public Student(String name, String gender, int grade, double gpa, List<String> activities) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.gpa = gpa;
        this.activities = activities;
    }
}
