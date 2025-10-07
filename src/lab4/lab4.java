package lab4;

import lab4.BinaryTree.BinaryTree;
import lab4.DateFormatter.DateFormatter;
import lab4.DateFormatter.Tester;
import lab4.PersonClass.Person;
import lab4.StringAnalyzer.StringSorter;
import lab4.StringAnalyzer.StringToSetAnalyzer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class lab4 {
    /**
     * Код для задания 1
     */
    public static void task1(){
        // Инициализация объекта человека
        Person person = new Person(0, "Boris", "Balovnev", "Olegovich",
                new GregorianCalendar(2002, Calendar.JANUARY, 22));

        System.out.println("Созданный объект типа человек");
        System.out.println(person);

        System.out.println("Вывод даты в коротком формате");
        System.out.println(person.birthdayToString('s'));
        System.out.println("Вывод даты в среднем формате");
        System.out.println(person.birthdayToString('m'));
        System.out.println("Вывод даты в полном формате");
        System.out.println(person.birthdayToString('l'));
    }

    /**
     * Код для задания 2
     */
    public static void task2() {
        // Ввод даты
        System.out.println("Введите дату в формате:\n" +
                "<Год><Месяц><Число>\n" +
                "<Часы><минуты>");
        Scanner input = new Scanner(System.in);
        String date_line = input.nextLine();

        Calendar calendar = DateFormatter.formatDate(date_line);
        System.out.println("Созданный объект Calendar:");
        System.out.println(DateFormatter.dateToString(calendar));

        System.out.println("Результат прохождения тестов:");
        Tester.test();
    }

    /**
     * Код для задания 3
     */
    public static void task3() {
        // Примерочные строки
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "orange";
        String str4 = "grape";

        // Выводы....
        System.out.println("Символы в строке 1: '" + str1 + "'");
        System.out.println('<' + StringToSetAnalyzer.toSetString(str1) + '>');
        System.out.println("Символы в строке 2: '" + str2 + "'");
        System.out.println('<' + StringToSetAnalyzer.toSetString(str2) + '>');
        System.out.println("Символы в строке 3: '" + str3 + "'");
        System.out.println('<' + StringToSetAnalyzer.toSetString(str3) + '>');
        System.out.println("Символы в строке 4: '" + str4 + "'");
        System.out.println('<' + StringToSetAnalyzer.toSetString(str4) + '>');
        System.out.println();

        System.out.println("Вывод символов, входящих во вторую и в третью строку, в алфавитном (обычном) порядке");
        System.out.println(StringSorter.sort(StringToSetAnalyzer.getOpAndChars(str2,str3)));
        System.out.println("Вывод символов, входящих в четвертую и не входящих во вторую строку, в обратном порядке");
        System.out.println(StringSorter.revSort(StringToSetAnalyzer.getOpExChars(str4,str2)));
        System.out.println("Вывод символов, входящих хотя бы в одну из первой и второй строк, в порядке, соответствующим заданию 3");
        System.out.println(StringSorter.hashSort(StringToSetAnalyzer.getOpOrChars(str1,str2)));

    }

    /**
     * Код для задания 4
     */
    public static void task4() {
        // Новое дерево
        BinaryTree tree = new BinaryTree();

        // Заполняем дерево значениями
        for (int i = 1; i <= 10; i++) {
            tree.insert((i+4)%10);
            tree.insert(i);
            tree.insert(10-i);
        }

        // Выводы
        System.out.println("Структура дерева: ");
        tree.print();

        System.out.println("Вывод для прямого прохода дерева: ");
        System.out.println(tree.straightPass());
        System.out.println("Вывод для центрированного прохода дерева: ");
        System.out.println(tree.centerPass());
        System.out.println("Вывод для обратного прохода дерева: ");
        System.out.println(tree.reversePass());

        System.out.println("Количество элементов в дереве: ");
        System.out.println(tree.length());
        System.out.println(" Максимальная глубина дерева: ");
        System.out.println(tree.maxDepth());
    }
}
