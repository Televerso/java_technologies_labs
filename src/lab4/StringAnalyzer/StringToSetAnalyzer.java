package lab4.StringAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для анализа строк
 */
public class StringToSetAnalyzer {
    /**
     * Преобразует set в строку без служебных символов
     * @param set объект set
     * @return raw-содержимое set
     */
    private static String getCleanString(Set<Character> set) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(set);

        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Производит частотный анализ слов в строке
     * @param str передаваемая строка для анализа
     * @return HashMap, в котором ключами являются слова, а значениями - их количество в строке
     */
    public static HashMap<String,Integer> getWordFrequency(String str) {
        // TODO
        return null;
    }

    /**
     * Производит частотный анализ символов в строке
     * @param str передаваемая строка для анализа
     * @return HashMap, в котором ключами являются символы, а значениями - их количество в строке
     */
    public static HashMap<Character,Integer> getCharFrequency(String str) {
        // TODO
        return null;
    }

    /**
     * Определяет символы, входящие в первую и вторую строку (операция пересечения множеств)
     * @param str1 строка 1
     * @param str2 строка 2
     * @return символы, встречающиеся в обоих строках
     */
    public static String getOpAndChars(String str1, String str2) {
        // Обе строки преобразуются в set
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        // Находится пересечение двух множеств
        set1.retainAll(set2);
        return getCleanString(set1);
    }

    /**
     * Определяет символы, входящие в первую и не входящие вторую строку (операция исключения)
     * @param str1 строка 1
     * @param str2 строка 2
     * @return символы, встречающиеся в первой, но не второй строке
     */
    public static String getOpExChars(String str1, String str2) {
        // Обе строки преобразуются в set
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        // Находится исключение множеств
        set1.removeAll(set2);

        return getCleanString(set1);
    }

    /**
     * Определяет символы, содержащиеся хотя бы в одной строке (операция объединения)
     * @param str1 строка 1
     * @param str2 строка 2
     * @return символы содержащиеся хотя бы в одной строке
     */
    public static String getOpOrChars(String str1, String str2) {
        // Обе строки преобразуются в set
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        // Находится объединение множеств
        set1.addAll(set2);
        return getCleanString(set1);
    }

    /**
     * Выводит все символы, встречающиеся в это строке
     * @param str передаваемая строка
     * @return символы, содержащиеся в строке, без повторов
     */
    public static String toSetString(String str) {
        Set<Character> set = new HashSet<>(str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        return getCleanString(set);
    }
}
