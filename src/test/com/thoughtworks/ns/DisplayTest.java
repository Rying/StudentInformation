package com.thoughtworks.ns;

import com.google.common.collect.ImmutableSet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DisplayTest {
    Display display = new Display();
    private List<Student> students;

    @Before
    public void setUp() {
        students = new ArrayList<>(ImmutableSet.of(new Student("A", 100), new Student("B", 80), new Student("C", 59)));
    }

    @Test
    public void should_output_is_A100() {
        assertThat(display.displayInArabicScore(new Student("A", 100)), is("A,100"));
    }

    @Test
    public void should_output_different_students_information_in_different_line() {
        assertThat(display.displayInArabicScore(students), is("A,100\n" +
                "B,80\n" +
                "C,59"));
    }

    @Test
    public void should_output_A100_in_json_right() {
        assertThat(display.jsonDisplayInArabicScore(new Student("A", 100)), is("{A:100}"));
    }

    @Test
    public void should_output_all_students_in_json_right() {
        assertThat(display.jsonDisplayInArabicScore(students), is("{A:100,B:80,C:59}"));
    }

    @Test
    public void should_output_A100_in_Roma_is_AC() {
        assertThat(display.displayInRomaScore(new Student("A", 100)), is("A,C"));
    }

    @Test
    public void should_output_different_students_information_in_different_line_in_Roma() {
        assertThat(display.displayInRomaScore(students), is("A,C\n" +
                "B,LXXX\n" +
                "C,LIX"));
    }

    @Test
    public void should_output_A100_in_JsonRoma_is_right() {
        assertThat(display.jsonDisplayInRomaScore(new Student("A", 100)), is("{A:C}"));
    }

    @Test
    public void should_out_all_students_information_in_JsonRoma_is_right() {
        assertThat(display.jsonDisplayInRomaScore(students), is("{A:C,B:LXXX,C:LIX}"));
    }
}
