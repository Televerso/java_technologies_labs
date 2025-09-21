package lab3;
import lab3.PersonsAddress.Address;
import lab3.PersonsAddress.Person;
import lab3.ShirtClass.Shirt;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class lab3 {
    /**
     * Код для задания 1
     */
    public static void task1(){
        System.out.println("Пример вывода двух sql запросов:");
        System.out.println(SqlInstructionBuilder.sql_request("6401", 3));
        System.out.println(SqlInstructionBuilder.sql_request("6110", 2));
    }

    /**
     * Код для задания 2
     */
    public static void task2(){
        // Инициализация адреса
        Address address = new Address("Russia", "Samarskaya", "Samara",
                "1", "1", "1", "1");

        // Инициализация объекта человека
        Person person = new Person(0, "Boris", "Balovnev", "Olegovich",
                new GregorianCalendar(2002, Calendar.JANUARY, 22), address);

        System.out.println("Созданный объект типа человек");
        System.out.println(person);
        System.out.println("Вывод ФИО в формате Фамилия И.О.");
        System.out.println(person.nameToString());
    }

    /**
     * Код для задания 3
     */
    public static void task3(){
        System.out.println("Пример с заданным разделителем ','");
        System.out.println("Россия, Самарская область, Самара, Первая, д1, п1, 1");
        Address address1 = new Address("Россия, Самарская область, Самара, Первая, д1, п1, 1", ',');
        System.out.println(address1);

        System.out.println("Пример с заданным разделителем ';'");
        System.out.println("Россия; Самарская область; Самара; Вторая; д1; п1; 1");
        Address address2 = new Address("Россия; Самарская область; Самара; Вторая; д1; п1; 1", ';');
        System.out.println(address2);

        System.out.println("Пример с использованием StringTokenizer с одним типом разделителя");
        System.out.println("Россия; Самарская область; Самара; Вторая; д2; п3; 4");
        Address address3 = new Address("Россия; Самарская область; Самара; Вторая; д2; п3; 4");
        System.out.println(address3);

        System.out.println("Пример с использованием StringTokenizer с разными типами разделителей");
        System.out.println("Россия; Самарская область; Самара, Вторая; д4. п1. 17");
        Address address4 = new Address("Россия; Самарская область; Самара, Вторая; д4. п1. 17");
        System.out.println(address4);
    }

    /**
     * Код для задания 4
     */
    public static void task4(){
        // Дано:
        String[] str_shirts = new String[11];
        str_shirts[0] = "S001,Black Polo Shirt,Black,XL";
        str_shirts[1] = "S002,Black Polo Shirt,Black,L";
        str_shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        str_shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        str_shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        str_shirts[5] = "S006,Black T-Shirt,Black,XL";
        str_shirts[6] = "S007,White T-Shirt,White,XL";
        str_shirts[7] = "S008,White T-Shirt,White,L";
        str_shirts[8] = "S009,Green T-Shirt,Green,S";
        str_shirts[9] = "S010,Orange T-Shirt,Orange,S";
        str_shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        // Задание
        Shirt[] shirts = new Shirt[str_shirts.length]; // Создание массива
        // Заполнение массива
        for (int i = 0; i < str_shirts.length; ++i)
        {
            shirts[i] = new Shirt(str_shirts[i]);
        }
        // Вывод
        System.out.println("Вывод для первых трех маек в массиве");
        for (int i = 0; i < 3; ++i)
        {
            System.out.println(shirts[i]);
        }
    }

    /**
     * Код для задания 5
     */
    public static void task5()
    {
        System.out.println("Вывод для номера '+104289652211'");
        String number1 = "+104289652211";
        System.out.println(PhoneNumber.formatNumber(number1));

        System.out.println("Вывод для номера '+79175655655'");
        String number2 = "+79175655655";
        System.out.println(PhoneNumber.formatNumber(number2));

        System.out.println("Вывод для номера '89175655655'");
        String number3 = "89175655655";
        System.out.println(PhoneNumber.formatNumber(number3));
    }
}
