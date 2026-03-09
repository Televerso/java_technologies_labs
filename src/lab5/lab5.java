package lab5;
import java.util.Vector;

import lab5.task1.*;
import lab5.task2.*;
import lab5.task3.*;
import lab5.task4.*;

public class lab5 {

    public static void task1() {
        // Создание экземпляров MyThread
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start(); // Запуск первого потока
        myThread2.start(); // Запуск второго потока

        // Создание экземпляра Runnable
        MyRunnable myRunnable = new MyRunnable();

        // Передача Runnable в конструктор Thread и запуск
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);

        thread1.start(); // Запуск первого потока
        thread2.start(); // Запуск второго потока
    }

    public static void task2(){
        // Создаем вектор с начальными нулями
        Vector<Float> vector = new Vector<>();
        int vectorSize = 10;

        // Заполняем вектор нулями
        for (int i = 0; i < vectorSize; i++) {
            vector.add(0.0F);
        }

        System.out.println("=== СТАРТ ПРОГРАММЫ ===");
        System.out.println("Размер вектора: " + vectorSize);
        System.out.println("Начальное состояние: " + vector);
        System.out.println();

        // Создаем потоки
        WriterThread writer = new WriterThread(vector);
        ReaderThread reader = new ReaderThread(vector);

        // Устанавливаем разные приоритеты (можно менять для экспериментов)
        writer.setPriority(Thread.NORM_PRIORITY);      // Обычный приоритет (5)
        reader.setPriority(Thread.NORM_PRIORITY + 2);  // Высокий приоритет (7)

        // Запускаем потоки
        writer.start();
        reader.start();

        // Ждем завершения
        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
        System.out.println("Итоговое состояние вектора: " + vector);
    }

    public static void task3() {
        int vectorSize = 10;

        // Создаем вектор и заполняем нулями
        Vector<Float> vector = new Vector<>();
        for (int i = 0; i < vectorSize; i++) {
            vector.add(0.0F);
        }

        System.out.println("=== ПРОГРАММА ЗАПУЩЕНА ===");
        System.out.println("Размер вектора: " + vectorSize);
        System.out.println("Начальное состояние: " + vector);
        System.out.println();

        // Создаем менеджер синхронизации
        SyncManager syncManager = new SyncManager(vectorSize);

        // Создаем писателя и читателя
        SyncWriter writer = new SyncWriter(vector, syncManager, "Writer");
        SyncReader reader = new SyncReader(vector, syncManager, "Reader");

        // Создаем потоки
        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);

        System.out.println("Запуск потоков...\n");

        // Запускаем потоки
        writerThread.start();
        readerThread.start();

        // Ждем завершения
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
        System.out.println("Итоговое состояние вектора: " + vector);
    }

    public static void task4() {
        System.out.println("=== ТЕСТИРОВАНИЕ SYNCHRONIZED VECTOR ===\n");

        // Создаем обычный вектор
        Vector<String> originalVector = new Vector<>();
        originalVector.add("Первый");
        originalVector.add("Второй");
        originalVector.add("Третий");

        System.out.println("Оригинальный вектор: " + originalVector);
        System.out.println("Тип: " + originalVector.getClass().getSimpleName());
        System.out.println();

        // Получаем синхронизированную оболочку
        Vector<String> syncVector = VectorUtils.synchronizedVector(originalVector);

        System.out.println("Синхронизированная оболочка: " + syncVector);
        System.out.println("Тип: " + syncVector.getClass().getSimpleName());
        System.out.println();

        // Тестируем методы
        System.out.println("Тестирование методов:");
        System.out.println("  size(): " + syncVector.size());
        System.out.println("  get(1): " + syncVector.get(1));
        System.out.println("  contains('Первый'): " + syncVector.contains("Первый"));

        syncVector.add("Четвертый");
        System.out.println("  После add(): " + syncVector);

        syncVector.set(0, "Новый первый");
        System.out.println("  После set(): " + syncVector);

        syncVector.remove(2);
        System.out.println("  После remove(): " + syncVector);

        System.out.println("\nОригинальный вектор тоже изменился: " + originalVector);
    }
}
