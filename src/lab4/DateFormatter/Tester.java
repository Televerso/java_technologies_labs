package lab4.DateFormatter;

/**
 * Проверочный класс для второго задания
 */
public class Tester {
    public static void test() {
        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002-02-02 20:02")).equals("02.02.2002 20:02"))
            throw new AssertionError("Test #1 - basic");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2020-12-31 22:48")).equals("31.12.2020 22:48"))
            throw new AssertionError("Test #2 - basic2");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002-20-02 20:02")).equals("02.08.2003 20:02"))
            throw new AssertionError("Test #3 - month overflow");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002 02 02 20 02")).equals("02.02.2002 20:02"))
            throw new AssertionError("Test #4 - spaces as dividers");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002;10-10.20:02")).equals("10.10.2002 20:02"))
            throw new AssertionError("Test #5 - different dividers");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2008-07-04")).equals("04.07.2008 00:00"))
            throw new AssertionError("Test #6 - no time");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002-Feb-02 20:02")).equals("02.02.2002 20:02"))
            throw new AssertionError("Test #7 - month in short text format");

        if(!DateFormatter.dateToString(DateFormatter.formatDate("2002-January-02 00:00")).equals("02.01.2002 00:00"))
            throw new AssertionError("Test #8 - month in long text format");

        System.out.println("Pass");
    }
}
