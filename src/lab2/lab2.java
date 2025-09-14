package lab2;

import lab1.GameOfDice;
import lab2.AniVoice.*;

import lab2.Cat.*;
import lab2.ExtendedClass.ExtendedClass;
import lab2.GameOfDice.GameOfDice2;

import java.util.Scanner;


public class lab2 {

    /**
     * Код для задания 1
     */
    public static void task1(){
        AniVoice dog = new Dog();
        AniVoice cat = new Cat();
        AniVoice cat2 = new Cat();
        AniVoice cow = new Cow();

        System.out.println("dog.voice()");
        dog.voice();
        System.out.println("cat.voice()");
        cat.voice();
        System.out.println("cat2.voice()");
        cat2.voice();
        System.out.println("cow.voice()");
        cow.voice();
    }

    /**
     * Код для задания 2
     */
    public static void task2() {
        // Ввод начальных значений с консоли
        Scanner input = new Scanner(System.in);
        System.out.println("Введите параметр N: ");
        int n = input.nextInt();
        System.out.println("Введите параметр M: ");
        int m = input.nextInt();

        // Запуск игры
        GameOfDice2 gameOfDice = new GameOfDice2(n,m);
        gameOfDice.play(3);
    }

    /**
     * Код для задания 3
     */
    public static void task3() {
        ExtendedClass ext1 = new ExtendedClass((byte) 1, 9, 0.5, "Hello");
        ExtendedClass ext2 = new ExtendedClass((byte) 1, 9, 0, "Hello");

        ExtendedClass ext3 = new ExtendedClass((byte) 1, 1, 1, "world!");
        ExtendedClass ext4 = new ExtendedClass((byte) 1, 1, 1, "world!");

        System.out.println("Строковые представления объектов класса:");
        System.out.println(ext1.toString());
        System.out.println(ext2.toString());
        System.out.println(ext3.toString());
        System.out.println(ext4.toString());

        System.out.println("Проверка на равенство 1 и 2 объектов:");
        System.out.println(ext1.equals(ext2));
        System.out.println("Проверка на равенство 1 и 3 объектов:");
        System.out.println(ext1.equals(ext3));
        System.out.println("Проверка на равенство 3 и 4 объектов:");
        System.out.println(ext3.equals(ext4));

        System.out.println("Хэш для 1 объекта:");
        System.out.println(ext1.hashCode());
        System.out.println("Хэш для 2 объекта:");
        System.out.println(ext2.hashCode());
        System.out.println("Хэш для 3 объекта:");
        System.out.println(ext3.hashCode());
        System.out.println("Хэш для 4 объекта:");
        System.out.println(ext4.hashCode());
        System.out.println("Видно, что хэши 3 и 4 объектов совпадают, поскольку они одинаковы.");
    }

    /**
     * Код для задания 4
     */
    public static void task4() {
        CatInterface cat = new CatImpl("Ника");

        cat.isHungry();
        cat.feed();
        cat.isHungry();
    }
}
