package ru.tolstov.hw12.studentGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GradeService<T extends Number> {
    List<StudentGrade<T>> studentGradeList = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> studentGrade) {
        if (studentGrade == null || studentGrade.getGrade() == null || studentGrade.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException(
                    "Передано невалидное значение: " + studentGrade + ", оценка не может быть  null или отрицательной, studentGrade не должен быть null "
            );
        }
        studentGradeList.add(studentGrade);
    }

    public synchronized double getAverageGrade(String lessonName) {
        return studentGradeList.stream()
                .filter(Objects::nonNull)
                .filter(stg -> Objects.nonNull(stg.getGrade()))
                .filter(studentGrade -> Objects.equals(lessonName, studentGrade.getLessonName()))
                .collect(Collectors.averagingDouble(stg -> stg.getGrade().doubleValue()));
    }
}