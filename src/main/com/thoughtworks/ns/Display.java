package com.thoughtworks.ns;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

import java.util.List;

import static com.google.common.collect.Lists.transform;

public class Display {

    public String displayInArabicScore(Student student) {
        return student.getName() + "," + student.getScore();
    }

    public String displayInArabicScore(List<Student> students) {
        return Joiner.on("\n").join(getStudentsInformationInArabic(students));
    }

    private List<String> getStudentsInformationInArabic(List<Student> students) {
        return transform(students, getEachStudentInformationInArabic());
    }

    private Function<Student, String> getEachStudentInformationInArabic() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return displayInArabicScore(student);
            }
        };
    }

    public String jsDisplayInArabicScore(Student student) {
        return "{" + getOneStudentInformationInArabicJson(student) + "}";
    }

    private String getOneStudentInformationInArabicJson(Student student) {
        return student.getName() + ":" + student.getScore();
    }

    public String jsDisplayInArabicScore(List<Student> students) {
        return "{" + Joiner.on(",").join(getStudentsInformationArabicJson(students)) + "}";
    }

    private List<String> getStudentsInformationArabicJson(List<Student> students) {
        return transform(students, getEachStudentInformationArabicJson());
    }

    private Function<Student, String> getEachStudentInformationArabicJson() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return getOneStudentInformationInArabicJson(student);
            }
        };
    }

    public String displayInRomaScore(Student student) {
        return student.getName() + "," + student.getRomaScore();
    }

    public String displayInRomaScore(List<Student> students) {
        return Joiner.on("\n").join(getStudentsInformationInRoma(students));
    }

    private List<String> getStudentsInformationInRoma(List<Student> students) {
        return transform(students, getEachStudentInformationInRoma());
    }

    private Function<Student, String> getEachStudentInformationInRoma() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return displayInRomaScore(student);
            }
        };
    }

    public String jsDisplayInRomaScore(Student student) {
        return "{" + getOneStudentInformationInRomaJson(student) + "}";
    }

    private String getOneStudentInformationInRomaJson(Student student) {
        return student.getName() + ":" + student.getRomaScore();
    }

    public String jsDisplayInRomaScore(List<Student> students) {
        return "{" + Joiner.on(",").join(getStudentsInformationInRomaJson(students)) + "}";
    }

    private List<String> getStudentsInformationInRomaJson(List<Student> students) {
        return transform(students, getEachStudentInformationInRomaJson());
    }

    private Function<Student, String> getEachStudentInformationInRomaJson() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return getOneStudentInformationInRomaJson(student);
            }
        };
    }
}

