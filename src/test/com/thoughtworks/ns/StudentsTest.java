package com.thoughtworks.ns;

import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentsTest {
    private final Students students = new Students();

    @Before
    public void setUp() {
        students.addStudent(new Student("A", 100));
        students.addStudent(new Student("B", 80));
        students.addStudent(new Student("C", 59));
    }

    @Test
    public void should_get_all_students() {
        assertThat(students.getAllStudents(), is((List) new ArrayList<>(ImmutableSet.of(new Student("A", 100), new Student("B", 80), new Student("C", 59)))));
    }

    @Test
    public void should_get_students_score_more_than_60() {
        assertThat(students.getPassedStudents(), is((List) new ArrayList<>(ImmutableSet.of(new Student("A", 100), new Student("B", 80)))));
    }
}
