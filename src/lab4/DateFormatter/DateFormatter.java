package lab4.DateFormatter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * Класс со статическими методами для работы с датами
 */
public class DateFormatter {
    /**
     * Проверяет, является ли содержимое строки int
     * @param str передаваемая строка
     * @return true/false
     */
    private static boolean isNumber(String str)
    {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Конвертирует тестовое представление месяца в числовой формат
     * @param month строка вида "february" или 'feb" (регистр не учитывается)
     * @return число - номер месяца (от 1 до 12)
     */
    private static int MonthToInt(String month){
        month = month.toLowerCase();
        switch(month) {
            case "january":
            case "jan":
                month = "1";
                break;

            case "febuary":
            case "feb":
                month = "2";
                break;

            case "march":
            case "mar":
                month = "3";
                break;

            case "april":
            case "apr":
                month = "4";
                break;

            case "may":
                month = "5";
                break;

            case "june":
            case "jun":
                month = "6";
                break;

            case "july":
            case "jul":
                month = "7";
                break;

            case "august":
            case "aug":
                month = "8";
                break;

            case "september":
            case "sep":
            case "sept":
                month = "9";
                break;

            case "october":
            case "oct":
                month = "10";
                break;

            case "november":
            case "nov":
                month = "11";
                break;

            case "december":
            case "dec":
                month = "12";
                break;
            default:
                throw new NumberFormatException("Invalid month: " + month);
        }
        return Integer.parseInt(month);
    }

    /**
     * Конвертирует строку в объект типа Calendar
     * @param input строка в формате <Год><Месяц><Число> или <Год><Месяц><Число><Час><Минута>
     *              <br> (возможные разделители ' :;.,-')
     * @return объект Calendar, соответствующий введенной дате
     */
    public static Calendar formatDate(String input) {
        if (input == null) {throw new NullPointerException();}
        if (input.isEmpty()) {throw new IllegalArgumentException();}

        input = input.trim();

        StringTokenizer st = new StringTokenizer(input, " :;.,-");
        // Проверка количества введенных значений
        if (st.countTokens() != 3 && st.countTokens() != 5) {throw new IllegalArgumentException();}

        // Обработка первого значения - года даты
        int year = Integer.parseInt(st.nextToken());

        // Обработка второго значения - месяца даты
        int month;
        String month_str = st.nextToken();
        // Месяц представлен в виде числа формата MM
        if (isNumber(month_str) && (month_str.length() == 2)) {
            month = Integer.parseInt(month_str);
        }
        // Месяц в строковом виде
        else if (!isNumber(month_str)) {
            month = MonthToInt(month_str);
        }
        else {
            throw new IllegalArgumentException("Invalid month: " + month_str);
        }

        // Обработка третьего значения - день даты
        int day = Integer.parseInt(st.nextToken());

        // Проверяем, остались ли в буфере еще значения
        if (st.countTokens() > 0)
        {
            // Если да, обрабатываем их - час и минуту
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());

            return new GregorianCalendar(year, month-1, day, hour, minute);
        }
        else {
            return new GregorianCalendar(year, month-1, day);
        }
    }

    /**
     * Преобразует объект типа Calendar к строковому представлению
     * @param date объект Calendar
     * @return строковое представление даты в формате DD.MM.YYYY HH:mm
     */
    public static String dateToString(Calendar date) {
        StringBuilder str = new StringBuilder();

        if (date.get(Calendar.DAY_OF_MONTH)< 10) str.append('0');
        str.append(date.get(Calendar.DAY_OF_MONTH));
        str.append('.');

        if (date.get(Calendar.MONTH) + 1 < 10) str.append('0');
        str.append(date.get(Calendar.MONTH) + 1);
        str.append('.');

        str.append(date.get(Calendar.YEAR));
        str.append(' ');

        if (date.get(Calendar.HOUR_OF_DAY)<10) str.append('0');
        str.append(date.get(Calendar.HOUR_OF_DAY));
        str.append(':');

        if (date.get(Calendar.MINUTE)<10) str.append('0');
        str.append(date.get(Calendar.MINUTE));

        return str.toString();
    }
}
