package lab3;

/**
 * Класс для форматирования телефонных номеров
 */
public class PhoneNumber {
    /**
     * Метод, который получает строковое представление телефонного номера в одном из двух возможных строковых форматов: <br>
     * +[Код страны][Номер 10 цифр], например “+79175655655” или “+104289652211”<br>
     * или<br>
     * 8[Номер 10 цифр] для России, например “89175655655”<br>
     * и преобразует полученную строку в формат:<br>
     * +[Код страны][Три цифры]–[Три цифры]–[Четыре цифры]<br>
     * @param number не отформатированный телефонный номер
     * @return отформатированный телефонный номер
     * @throws NullPointerException если был передан аргумент null
     * @throws ArrayIndexOutOfBoundsException если переданный номер короче 11 символов
     * @throws IllegalArgumentException если был передан номер в неверном формате
     */
    public static String formatNumber(String number) {
        if (number == null) {throw new NullPointerException();}
        if (number.length() < 11) {throw new ArrayIndexOutOfBoundsException("Invalid phone number");}

        if (number.charAt(0) == '+') {
            return '+' +
                    number.substring(1, number.length() - 10) +
                    '(' +
                    number.substring(number.length() - 10, number.length() - 7) +
                    ")-" +
                    number.substring(number.length() - 7, number.length() - 4) +
                    '-' +
                    number.substring(number.length() - 4);
        }
        else if (number.charAt(0) == '8' && number.length() == 11) {
            return "+7" +
                    '(' +
                    number.substring(1, 4) +
                    ")-" +
                    number.substring(4, 7) +
                    '-' +
                    number.substring(7);
        }
        else {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
