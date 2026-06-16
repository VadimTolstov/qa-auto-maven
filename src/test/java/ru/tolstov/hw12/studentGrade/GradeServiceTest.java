package ru.tolstov.hw12.studentGrade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
     * 2	addGrade (валидный)	                StudentGrade("Иван", "Химия", 0)	                            Размер списка становится 1,содержит Иван
     * 2	addGrade (отрицательная)	        StudentGrade("Иван", "Химия", -0.1)	                            InvalidGradeException
     * 3	addGrade (null-оценка)	            StudentGrade("Иван", "Химия", null)	                            InvalidGradeException
     * 4	addGrade (null-объект)	            null	                                                        InvalidGradeException
     * 5	addGrade (Integer)	                StudentGrade("Петр", "Физика", 90) (тип Integer)	            Успешное добавление
     * 6	getAverageGrade (пусто)	            Список пуст, запрос "Математика"	                            0.0
     * 7	getAverageGrade (нет совпадений)	Добавлена ("Анна", "Физика", 80.0), запрос "Математика"	        0.0
     * 8	getAverageGrade (норма)	            (70.0, Математика), (80.0, Математика), (90.0, Математика)	    80.0
     * 9	getAverageGrade (с null)	        Добавлены null-элемент, (оценка=null), (50.0), (70.0)	60.0    (игнорирует некорректные)
     * 10	getAverageGrade (один)	            (42.0, Математика)	                                            42.0
     * 11	getAverageGrade (null предмет)	    getAverageGrade(null)	                                        InvalidGradeException отбросит невалидный
     * 12	getAverageGrade (пустой предмет)	getAverageGrade(" ")	                                        InvalidGradeException пропустит
     * 13	Многопоточность	                    10 потоков по 100 добавлений (1.0)	                            Размер списка = 1000 после завершения всех потоков
     */

    @Test
    void addGrade() {
    }

    @Test
    void getAverageGrade() {
    }
}