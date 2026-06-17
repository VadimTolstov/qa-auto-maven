package ru.tolstov.hw12.studentGrade;

public class StudentGrade<T extends Number> {
    private final String name;
    private final String lessonName;
    private final T grade;

    public StudentGrade(String name, String lessonName, T grade) {
        this.name = name;
        this.lessonName = lessonName;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getLessonName() {
        return lessonName;
    }

    public T getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "name='" + name + '\'' +
                ", lessonName='" + lessonName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
