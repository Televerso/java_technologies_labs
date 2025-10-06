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
    public static void task2(){
        Scanner input = new Scanner(System.in);
        String date_line = input.nextLine();
        Calendar calendar = DateFormatter.formatDate(date_line);
        System.out.println(DateFormatter.dateToString(calendar));

        Tester.test();
    }
    public static void task3(){
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "orange";
        String str4 = "grape";

        System.out.println(StringToSetAnalyzer.toSetString(str1));
        System.out.println(StringToSetAnalyzer.toSetString(str2));
        System.out.println(StringToSetAnalyzer.toSetString(str3));
        System.out.println(StringToSetAnalyzer.toSetString(str4)+'\n');

        System.out.println(StringSorter.sort(StringToSetAnalyzer.getOpAndChars(str2,str3)));
        System.out.println(StringSorter.revSort(StringToSetAnalyzer.getOpExChars(str4,str2)));
        System.out.println(StringSorter.hashSort(StringToSetAnalyzer.getOpOrChars(str2,str3)));

    }

    public static void task4(){
        BinaryTree tree = new BinaryTree();

        for (int i = 1; i <= 10; i++) {
            tree.insert((i+4)%10);
            tree.insert(i);
        }

        System.out.println(tree.straightPass());
        System.out.println(tree.centerPass());
        System.out.println(tree.reversePass());

        System.out.println(tree.length());
        System.out.println(tree.maxDepth());
    }
}
