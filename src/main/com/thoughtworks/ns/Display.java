package com.thoughtworks.ns;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import net.sf.json.JSONObject;

import java.util.List;

import static com.google.common.collect.Lists.transform;

public class Display {
    public String getRomaScore(Student student) {
        String[][] RomaNumbers = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XCC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}};
        String RomaScore = "";
        int factor, digit = 2;

        for (factor = 100; factor > 0; factor /= 10) {
            RomaScore += RomaNumbers[digit][(student.getScore() / factor) % 10];
            digit--;
        }

        return RomaScore;
    }

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

    public String jsonDisplayInArabicScore(Student student) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(student.getName(), student.getScore());

        return jsonObject.toString().replace("\"", "");
    }

    public String jsonDisplayInArabicScore(List<Student> students) {
        JSONObject jsonObject = new JSONObject();
        for (Student student : students) {
            jsonObject.element(student.getName(), student.getScore());
        }
        return jsonObject.toString().replace("\"", "");
    }

    public String displayInRomaScore(Student student) {
        return student.getName() + "," + getRomaScore(student);
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

    public String jsonDisplayInRomaScore(Student student) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.element(student.getName(), getRomaScore(student));
        return jsonObject.toString().replace("\"", "");
    }

    public String jsonDisplayInRomaScore(List<Student> students) {
        JSONObject jsonObject = new JSONObject();
        for (Student student : students) {
            jsonObject.element(student.getName(), getRomaScore(student));
        }
        return jsonObject.toString().replace("\"", "");
    }
}

