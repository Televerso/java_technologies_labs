import lab1.GameOfDice;
import lab1.PersonsAddress.Address;
import lab1.PersonsAddress.Person;
import lab1.PersonsAddress.PersonsAddress;
import lab1.SquareSolver;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task2();
    }

    /**
     * Код для задания 1
     */
    public static void task1() {
        // Ввод исходных данных с консоли
        Scanner input = new Scanner(System.in);
        System.out.println("Enter parameter a: ");
        double a = input.nextDouble();
        System.out.println("Enter parameter b: ");
        double b = input.nextDouble();
        System.out.println("Enter parameter c: ");
        double c = input.nextDouble();

        // Решение уравнения
        SquareSolver square_problem = new SquareSolver(a,b,c);
        List<Double> solution = square_problem.solve();

        // Вывод ответа в консоль
        System.out.println("x1, x2 = " + solution);
    }

    /**
     * Код для задания 2
     */
    public static void task2() {
        // Ввод начальных значений с консоли
        Scanner input = new Scanner(System.in);
        System.out.println("Enter parameter N: ");
        int n = input.nextInt();
        System.out.println("Enter parameter M: ");
        int m = input.nextInt();

        // Запуск игры
        GameOfDice gameOfDice = new GameOfDice(n,m);
        gameOfDice.play(2);
    }

    /**
     * Код для задания 3
     */
    public static void task3() {
        // Инициализация адресов
        Address address1 = new Address("Russia", "Samara", "1", "1", "1");
        Address address2 = new Address("Russia", "Samara", "1", "2", "1");
        Address address3 = new Address("Russia", "Samara", "2", "2", "2");
        Address address4 = new Address("Russia", "Samara", "3", "44", "3");

        // Инициализация списка людей с вышеуказанными адресами
        List<Person> people = new ArrayList<Person>();
        people.add(new Person(0, "Oleg", "Olegovich", new GregorianCalendar(2002, Calendar.JANUARY, 22), address1));
        people.add(new Person(1, "Ivan", "Ivanovich", new GregorianCalendar(2001, Calendar.FEBRUARY,2), address2));
        people.add(new Person(2, "Petr", "Petrovich", new GregorianCalendar(2001, Calendar.DECEMBER,6), address3));
        people.add(new Person(3, "Greg", "Gregovich", new GregorianCalendar(2000, Calendar.AUGUST,4), address4));

        // Инициализация таблицы человек-адрес
        PersonsAddress table = new PersonsAddress(people);

        // Вывод таблицы в консоль
        System.out.println("Исходная таблица: ");
        System.out.println(table);

        // Проверка метода поиска по фамилии
        System.out.println("Список людей с фамилией 'Petrov': ");
        System.out.println(table.findBySurname("Petrov"));
        System.out.println("Список людей с фамилией 'Petrovich': ");
        System.out.println(table.findBySurname("Petrovich"));

        // Проверка метода поиска по атрибуту адреса
        System.out.println("Список людей, проживающих в квартирах с номером 1: ");
        System.out.println(table.findByAddressAttribute("1",4));

        // Проверка метода поиска по диапазону дат рождения
        System.out.println("Список людей, родившихся в промежутке от 01.01.2001 и 01.01.2002: ");
        System.out.println(table.findPersonByDateRange(new GregorianCalendar(2001, Calendar.JANUARY, 1),
                new GregorianCalendar(2002, Calendar.JANUARY, 1)));

        // Проверка поиска самого старшего и младшего в списке
        System.out.println("Самый младший человек с таблице: ");
        System.out.println(table.findYoungest());
        System.out.println("Самый старший человек с таблице: ");
        System.out.println(table.findOldest());

        // Проверка поиска людей, проживающих на одной улице
        System.out.println("Список людей, живущих в России, в городе Самара на улице 1: ");
        System.out.println(table.findSameStreet("Russia","Samara", "1"));
    }
}