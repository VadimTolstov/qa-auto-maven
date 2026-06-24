package ru.tolstov.hw12.taskManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    /**
     * №	Проверка                                    	Входные данные	                                            Ожидаемый результат
     * 1	Добавление и фильтрация по статусу/приоритету	3 задачи: (1, ToDo, High, 01.01), (2, Done, Low, 03.01),
     *                                                      (3, ToDo, High, 02.01). Запрос ToDo+High	                Возвращаются задачи с id=1 и id=3 (размер 2)
     * 2	Удаление существующей задачи по ID	            Добавлена задача id=1, вызов remove(1)	                    Метод возвращает true, после удаления ToDo+High пусто
     * 3	Удаление несуществующего ID	                    Добавлена задача id=1, вызов remove(999)	                Метод возвращает false
     * 4	Сортировка по дате (возрастание)	            Задачи с датами 03.01, 01.01, 02.01	                        Порядок: 01.01 → 02.01 → 03.01
     * 5	Сортировка по дате (убывание)	                Те же задачи	                                            Порядок: 03.01 → 02.01 → 01.01
     * 6	Дата сохраняется без времени	                Дата с временем 14:30:45.123	                            Поля времени (часы, минуты, секунды, мс) равны 0
     * 7	Добавление null	                                service.add(null)	                                        NullPointerException
     * 8	Удаление с null ID	                            service.remove(null)	                                    NullPointerException
     * 9	Фильтрация с null статусом	                    getTasksByStatusAndPriority(null, ...)	                    NullPointerException
     * 10	Фильтрация с null приоритетом	                getTasksByStatusAndPriority(..., null)	                    NullPointerException
     * 11	Создание задачи с null ID	                    new Task<>(null, ...)	                                    NullPointerException
     */

    private TaskService<Integer> service;
    private Task<Integer> task1;
    private Task<Integer> task2;
    private Task<Integer> task3;

    @BeforeEach
    void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2026, Calendar.JANUARY, 1, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date d1 = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date d2 = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 3);
        Date d3 = cal.getTime();
        service = new TaskService<>();
        task1 = new Task<>(1, Status.ToDo, Priority.High, d1);
        task2 = new Task<>(2, Status.Done, Priority.Low, d3);
        task3 = new Task<>(3, Status.ToDo, Priority.High, d2);
    }

    @Test
    void addTaskAndFilterByStatusAndPriority() {
        service.add(task1);
        service.add(task2);
        service.add(task3);

        Set<Task<Integer>> result = service.getTasksByStatusAndPriority(Status.ToDo, Priority.High);
        assertEquals(2, result.size());
        assertTrue(result.contains(task1));
        assertTrue(result.contains(task3));
        assertEquals(task1.getId(), result.stream().filter(t -> t.getId() == 1).findFirst().get().getId());
        assertEquals(task1.getPriority(), result.stream().filter(t -> t.getId() == 1).findFirst().get().getPriority());
        assertEquals(task1.getStatus(), result.stream().filter(t -> t.getId() == 1).findFirst().get().getStatus());
        assertEquals(task1.getDate(), result.stream().filter(t -> t.getId() == 1).findFirst().get().getDate());
    }

    @Test
    void removeExistingTaskReturnsTrue() {
        service.add(task1);
        Set<Task<Integer>> result = service.getTasksByStatusAndPriority(Status.ToDo, Priority.High);
        assertTrue(result.contains(task1));
        assertTrue(service.remove(task1.getId()));
        Set<Task<Integer>> result2 = service.getTasksByStatusAndPriority(Status.ToDo, Priority.High);
        assertFalse(result2.contains(task1));
    }

    @Test
    void removeNonExistingTaskReturnsFalse() {
        service.add(task1);
        assertFalse(service.remove(99));
        Set<Task<Integer>> result = service.getTasksByStatusAndPriority(Status.ToDo, Priority.High);
        assertTrue(result.contains(task1));
    }

    @Test
    void sortByDateAscending() {
        service.add(task2); // 2026-01-03
        service.add(task1); // 2026-01-01
        service.add(task3); // 2026-01-02

        Set<Task<Integer>> sorted = service.getTasksSortedByDateAsc();
        Iterator<Task<Integer>> it = sorted.iterator();
        assertEquals(task1.getId(), it.next().getId());
        assertEquals(task3.getId(), it.next().getId());
        assertEquals(task2.getId(), it.next().getId());
    }

    @Test
    void sortByDateDescending() {
        service.add(task2); // 2026-01-03
        service.add(task1); // 2026-01-01
        service.add(task3); // 2026-01-02

        Set<Task<Integer>> sorted = service.getTasksSortedByDateDesc();
        Iterator<Task<Integer>> it = sorted.iterator();
        assertEquals(task2.getId(), it.next().getId());
        assertEquals(task3.getId(), it.next().getId());
        assertEquals(task1.getId(), it.next().getId());
    }

    @Test
    void dateIsTruncatedToDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(2026, Calendar.JUNE, 15, 14, 30, 45);
        cal.set(Calendar.MILLISECOND, 123);
        Date rawDate = cal.getTime();

        Task<Integer> t = new Task<>(100, Status.Backlog, Priority.Medium, rawDate);
        Date stored = t.getDate();

        Calendar storedCal = Calendar.getInstance();
        storedCal.setTime(stored);
        assertEquals(0, storedCal.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, storedCal.get(Calendar.MINUTE));
        assertEquals(0, storedCal.get(Calendar.SECOND));
        assertEquals(0, storedCal.get(Calendar.MILLISECOND));

    }

    @Test
    void addNullTaskThrowsNPE() {
        assertThrows(NullPointerException.class, () -> service.add(null));
    }

    @Test
    void removeNullIdThrowsNPE() {
        assertThrows(NullPointerException.class, () -> service.remove(null));
    }

    @Test
    void filterWithNullStatusThrowsNPE() {
        assertThrows(NullPointerException.class, () -> service.getTasksByStatusAndPriority(null, Priority.Low));
    }

    @Test
    void filterWithNullPriorityThrowsNPE() {
        assertThrows(NullPointerException.class, () -> service.getTasksByStatusAndPriority(Status.ToDo, null));
    }

    @Test
    void constructTaskWithNullIdThrowsNPE() {
        assertThrows(NullPointerException.class, () -> new Task<>(null, Status.ToDo, Priority.Low, new Date()));
    }
}