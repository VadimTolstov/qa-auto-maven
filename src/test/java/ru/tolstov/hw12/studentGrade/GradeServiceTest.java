package ru.tolstov.hw12.studentGrade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GradeServiceTest {
    private GradeService<Double> gradeService;

    @BeforeEach
    void setUp() {
        gradeService = new GradeService<>();
    }

    /**
     * №	Тип теста	                        Входные данные (оценки, предмет)	                            Ожидаемый результат
     * 1	addGrade (валидный) 	            StudentGrade("Иван", "Химия", 95.0)	                            Размер списка становится 1,содержит Иван
     * 1	addGrade (валидный) 	StudentGrade("Иван", "Химия", 95.0),StudentGrade("Анна", "Физика", 55.55)	Размер списка становится 2, содержит Иван и Анну
     * 2	addGrade (валидный)	                StudentGrade("Иван", "Химия", 0.0)	                            Размер списка становится 1,содержит Иван
     * 5	addGrade (Integer)	                StudentGrade("Петр", "Физика", 90) (тип Integer)	            Успешное добавление
     * 2	addGrade (отрицательная)	        StudentGrade("Иван", "Химия", -0.1)	                            InvalidGradeException
     * 3	addGrade (null-оценка)	            StudentGrade("Иван", "Химия", null)	                            InvalidGradeException
     * 4	addGrade (null-объект)	            null	                                                        InvalidGradeException
     * 6	getAverageGrade (пусто)	            Список пуст, запрос "Математика"	                            0.0
     * 7	getAverageGrade (нет совпадений)	Добавлена ("Анна", "Физика", 80.0), запрос "Математика"	        0.0
     * 8	getAverageGrade (норма)	            (70.0, Математика), (80.0, Математика), (90.0, Математика)	    80.0
     * 9	getAverageGrade (с null)	        Добавлены null-элемент, (оценка=null), (50.0), (70.0)	60.0    (игнорирует некорректные)
     * 10	getAverageGrade (один)	            (42.0, Математика)	                                            42.0
     * 11	getAverageGrade (null предмет)	    getAverageGrade(null)	                                        отбросит невалидный
     * 13	Многопоточность	                    10 потоков по 100 добавлений (1.0)	                            Размер списка = 1000 после завершения всех потоков
     */

    public static Stream<Arguments> dataForValidationPositiveCases() {
        return Stream.of(
                Arguments.of(new StudentGrade<Double>("Иван", "Химия", 95.0)),
                Arguments.of(new StudentGrade<Double>("Иван", "Химия", 0.0))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCases")
    void checkValidAddGrade(StudentGrade<Double> studentGrade) {
        gradeService.addGrade(studentGrade);
        assertTrue(gradeService.studentGradeList.contains(studentGrade));
        final StudentGrade<Double> actualStudentGrade = gradeService.studentGradeList.getFirst();
        assertStudentGrade(studentGrade, actualStudentGrade);
    }

    @Test
    void checkValidAddGradeInteger() {
        final StudentGrade<Integer> studentGrade = new StudentGrade<Integer>("Петр", "Физика", 90);
        final GradeService<Integer> gradeIntegerService = new GradeService<>();
        gradeIntegerService.addGrade(studentGrade);
        assertTrue(gradeIntegerService.studentGradeList.contains(studentGrade));
        final StudentGrade<Integer> actualStudentGrade = gradeIntegerService.studentGradeList.getFirst();
        assertStudentGrade(studentGrade, actualStudentGrade);
    }

    @Test
    void checkValidAddGradeIfAddListTwoItems() {
        final StudentGrade<Double> studentGradeOne = new StudentGrade<Double>("Иван", "Химия", 95.0);
        final StudentGrade<Double> studentGradeTwo = new StudentGrade<Double>("Анна", "Физика", 55.55);
        gradeService.addGrade(studentGradeOne);
        assertEquals(1, gradeService.studentGradeList.size());
        gradeService.addGrade(studentGradeTwo);
        assertEquals(2, gradeService.studentGradeList.size());
        assertTrue(gradeService.studentGradeList.contains(studentGradeOne));
        assertTrue(gradeService.studentGradeList.contains(studentGradeTwo));

        final StudentGrade<Double> actualStudentGradeOne = gradeService.studentGradeList
                .stream()
                .filter(stg -> Objects.equals("Иван", stg.getName()))
                .findFirst().orElseThrow();
        final StudentGrade<Double> actualStudentGradeTwo = gradeService.studentGradeList
                .stream()
                .filter(stg -> Objects.equals("Анна", stg.getName()))
                .findFirst().orElseThrow();

        assertStudentGrade(studentGradeOne, actualStudentGradeOne);
        assertStudentGrade(studentGradeTwo, studentGradeTwo);
    }

    private void assertStudentGrade(StudentGrade<? extends Number> expectedStudentGrade, StudentGrade<? extends Number> actualStudentGrad) {
        assertEquals(expectedStudentGrade, actualStudentGrad);
        assertEquals(expectedStudentGrade.getGrade(), actualStudentGrad.getGrade());
        assertEquals(expectedStudentGrade.getLessonName(), actualStudentGrad.getLessonName());
        assertEquals(expectedStudentGrade.getName(), actualStudentGrad.getName());
    }

    public static Stream<Arguments> dataForInvalidAddGradeCases() {
        return Stream.of(
                Arguments.of(new StudentGrade<Double>("Иван", "Химия", -0.1)),
                Arguments.of(new StudentGrade<Double>("Иван", "Химия", null))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForInvalidAddGradeCases")
    void checkInvalidAddGrade(StudentGrade<Double> studentGrade) {
        extractedExceptionAddGrade(studentGrade);
    }


    @Test
    void checkExceptionIfArgumentInAddGradeNull() {
        extractedExceptionAddGrade(null);
    }

    private void extractedExceptionAddGrade(StudentGrade<Double> studentGrade) {
        InvalidGradeException invalidGradeException = Assertions.assertThrows(
                InvalidGradeException.class,
                () -> gradeService.addGrade(studentGrade)
        );
        assertEquals(
                "Передано невалидное значение: " + studentGrade
                        + ", оценка не может быть  null или отрицательной, studentGrade не должен быть null ",
                invalidGradeException.getMessage()
        );
    }

    @Test
    void checkGetAverageGradeIfListIsEmpty() {
        assertEquals(0.0, gradeService.getAverageGrade("Математика"));
    }

    @Test
    void checkGetAverageGradeIfNoMatches() {
        final StudentGrade<Double> studentGrade = new StudentGrade<>("Анна", "Физика", 80.0);
        gradeService.addGrade(studentGrade);
        assertTrue(gradeService.studentGradeList.contains(studentGrade));
        assertEquals(1, gradeService.studentGradeList.size());
        assertEquals(0.0, gradeService.getAverageGrade("Математика"));
    }

    @Test
    void checkGetAverageGrade() {
        gradeService.addGrade(new StudentGrade<>("Анна", "Математика", 70.0));
        gradeService.addGrade(new StudentGrade<>("Виктор", "Математика", 80.0));
        gradeService.addGrade(new StudentGrade<>("Олег", "Математика", 90.0));
        assertEquals(3, gradeService.studentGradeList.size());
        assertEquals(80.0, gradeService.getAverageGrade("Математика"));
    }

    @Test
    void checkGetAverageGradeIfListIsContainsNullAndGradeIsNull() {
        gradeService.studentGradeList.add(new StudentGrade<Double>("Анна", "Физика", null));
        gradeService.studentGradeList.add(null);
        gradeService.studentGradeList.add(new StudentGrade<>("Олег", "Физика", 50.0));
        gradeService.studentGradeList.add(new StudentGrade<>("Игорь", "Физика", 70.0));
        assertEquals(4, gradeService.studentGradeList.size());
        assertEquals(60.0, gradeService.getAverageGrade("Физика"));
    }

    @Test
    void checkGetAverageGradeIfListIsContainsOneItem() {
        gradeService.studentGradeList.add(new StudentGrade<>("Игорь", "Математика", 42.0));
        assertEquals(1, gradeService.studentGradeList.size());
        assertEquals(42.0, gradeService.getAverageGrade("Математика"));
    }

    @Test
    void checkGetAverageGradeIfLessonNameIsNull() {
        assertEquals(0.0, gradeService.getAverageGrade(null));
    }

    @Test
    void addGradeConcurrently() throws InterruptedException {
        int threadCount = 10;
        int additionsPerThread = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < additionsPerThread; j++) {
                        gradeService.addGrade(new StudentGrade<>("Студент", "Предмет", 1.0));
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();

        assertEquals(threadCount * additionsPerThread, gradeService.studentGradeList.size());
    }
}