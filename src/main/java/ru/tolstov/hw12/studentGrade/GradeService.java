package ru.tolstov.hw12.studentGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GradeService<T extends Number> {
    List<StudentGrade<T>> studentGradeList = new ArrayList<>();

    public synchronized void addGrade(StudentGrade<T> studentGrade) {
        validateStudentGrade(studentGrade);
        if (studentGrade.getGrade() == null || studentGrade.getGrade().doubleValue() < 0) {
            throw new InvalidGradeException(
                    "Передан невалидная оценка: " + studentGrade.getGrade() +
                            " оценка не может быть  null или отрицательной"
            );
        }
        studentGradeList.add(studentGrade);
    }

    public synchronized double getAverageGrade(String lessonName) {
        if (lessonName == null || lessonName.isBlank()) {
            throw new InvalidGradeException(
                    "Для расчета средней оценки по предмету: " + lessonName +
                            " , название урока не должно быть null или пустым"
            );
        }
        return studentGradeList.stream()
                .filter(Objects::nonNull)
                .filter(stg -> Objects.nonNull(stg.getGrade()))
                .filter(studentGrade -> Objects.equals(lessonName, studentGrade.getLessonName()))
                .collect(Collectors.averagingDouble(stg -> stg.getGrade().doubleValue()));
    }

    private void validateStudentGrade(StudentGrade<T> studentGrade) {
        if (studentGrade == null) {
            throw new InvalidGradeException("StudentGrade is null");
        }
    }
}