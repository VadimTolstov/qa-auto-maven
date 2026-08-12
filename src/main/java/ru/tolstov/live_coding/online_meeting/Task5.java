package ru.tolstov.live_coding.online_meeting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Задача 3. Работа переводчика
Переводчик печатает текст.
Необходимо определить максимальную длину фрагмента, в котором ни одно слово не встречается дважды.
Например

cat dog bird dog fish

Ответ

3

Потому что самый длинный уникальный фрагмент —

cat dog bird

[cat]

[cat dog]

[cat dog bird]

[cat dog bird dog]   ❌ повтор

    [dog bird dog]   ❌

        [bird dog]   ✔

        [bird dog fish]

        [bird dog fish apple]
 */
public class Task5 {

    private static int window(String[] array) {
        int left = 0;
        int right;
        int maxSize = 0;
        Set<String> stringSet = new HashSet<>();
        for (right = 0; right < array.length; right++) {
            if (!stringSet.contains(array[right])) {
                stringSet.add(array[right]);
            } else {
                stringSet.remove(array[left]);
                left++;
                right--;
            }
            maxSize = Math.max(maxSize, stringSet.size());
        }
        return maxSize;
    }

    private static int window2(String[] array) {
        Map<String, Integer> lastIndexMap = new HashMap<>();
        int left = 0;
        int maxSize = 0;

        for (int right = 0; right < array.length; right++) {
            String currentWord = array[right];

            if (lastIndexMap.containsKey(currentWord)) {
                // Если слово уже было, сдвигаем левую границу за его предыдущее вхождение
                int lastIdx = lastIndexMap.get(currentWord);
                left = Math.max(left, lastIdx + 1);
            }

            // Обновляем индекс текущего слова
            lastIndexMap.put(currentWord, right);

            // Вычисляем длину текущего окна и обновляем максимум
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(window(new String[]{"cat", "dog", "bird", "dog", "fish"}));
        System.out.println(window(new String[]{"a", "b", "c", "b", "c"}));
        System.out.println(window(new String[]{"a", "a", "a", "a"}));
    }
}
