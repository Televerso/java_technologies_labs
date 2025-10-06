package lab4.StringAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class StringToSetAnalyzer {
    private static String getCleanString(Set<Character> set) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(set);

        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String getOpAndChars(String str1, String str2) {
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));

        set1.retainAll(set2);
        return getCleanString(set1);
    }

    public static String getOpExChars(String str1, String str2) {
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));

        set1.removeAll(set2);

        return getCleanString(set1);
    }

    public static String getOpOrChars(String str1, String str2) {
        Set<Character> set1 = new HashSet<>(str1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        Set<Character> set2 = new HashSet<>(str2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        set1.addAll(set2);
        return getCleanString(set1);
    }

    public static String toSetString(String str) {
        Set<Character> set = new HashSet<>(str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList()));
        return getCleanString(set);
    }
}
