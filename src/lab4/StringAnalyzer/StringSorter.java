package lab4.StringAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс сортировки порядка символов в строке
 */
public class StringSorter {
    /**
     * Обычная сортировка символов
     * @param str передаваемая строка
     * @return отсортированная строка
     */
    public static String sort(String str) {
        char[] chars = str.toCharArray(); // Строку в массив символов
        Arrays.sort(chars); // Сортировка
        return new String(chars);
    }

    /**
     * Обратная сортировка символов
     * @param str передаваемая строка
     * @return отсортированная строка
     */
    public static String revSort(String str) {
        char[] chars = str.toCharArray(); // Строку в массив символов
        Arrays.sort(chars); // Сортировка
        // Обратный порядок
        for (int i = 0; i < chars.length/2; ++i) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
    }

    public static String hashSort(String str, int shiftBits) {
        return str.chars()
                .boxed()
                .sorted(Comparator.comparingInt(c -> Integer.rotateLeft(c.hashCode(), shiftBits)))
                .map(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


}
