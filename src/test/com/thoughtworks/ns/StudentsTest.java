package com.thoughtworks.ns;

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
        List<Student> another_students = new ArrayList<>();
        another_students.add(new Student("A", 100));
        another_students.add(new Student("B", 80));
        another_students.add(new Student("C", 59));

        assertThat(students.getAllStudents(), is(another_students));
    }

    @Test
    public void should_get_students_score_more_than_60() {
        List<Student> another_students = new ArrayList<>();
        another_students.add(new Student("A", 100));
        another_students.add(new Student("B", 80));

        assertThat(students.getPassedStudents(), is(another_students));
    }
}
