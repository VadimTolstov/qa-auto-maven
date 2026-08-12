package ru.tolstov.live_coding.online_meeting;

/*
Задача 1. Самый длинный период стабильной работы
Сервер ежедневно либо работал корректно (1), либо был недоступен (0).
Компания готова проигнорировать не более k аварий, считая, что они были ложными срабатываниями мониторинга.
Определите максимальную длину непрерывного периода, который можно считать стабильным.
Пример:

Статус по дням:

1 1 0 1 1 0 1 1 1

Можно проигнорировать одну аварию.
1)
[1]

2)
[1 1]

3)
[1 1 0]

4)
[1 1 0 1]

5)
[1 1 0 1 1]

6) добавили второй ноль

[1 1 0 1 1 0]   ❌

двигаем left

1 [1 0 1 1 0]   ❌
1 1 [0 1 1 0]   ❌
1 1 0 [1 1 0]   ✔

7)
1 1 0 [1 1 0 1]

8)
1 1 0 [1 1 0 1 1]

9)
1 1 0 [1 1 0 1 1 1] ← ответ 6
 */
public class Task4 {

    private static int window(int[] array, int k) {
        int left = 0;
        int right;
        int count = 0;
        for (right = 0; right < array.length; right++) {
            if (array[right] == 0) {
                count++;
            }
            if (count > k) {
                if (array[left] == 0) {
                    count--;
                }
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(window(new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0}, 1));
    }
}
