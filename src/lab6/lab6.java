package lab6;

import lab6.task1.*;
import lab6.task2.*;
import lab6.task2.ExperimentClass.*;
import lab6.task3.*;
import lab6.task4.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class lab6 {
    public static void task1() {
        System.out.println("=== ДЕМОНСТРАЦИЯ WAIT/NOTIFY ===\n");

        // Создаем разделяемые данные
        SharedData sharedData = new SharedData();

        // Создаем потоки
        ThreadA threadA = new ThreadA(sharedData);
        ThreadB threadB = new ThreadB(sharedData);

        // Запускаем потоки
        threadA.start();
        threadB.start();

        // Ждем завершения
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }

    public static void task2() {
        System.out.println("=== ЭКСПЕРИМЕНТ 1: ОБЩАЯ ПЕРЕМЕННАЯ ===\n");
        ExperimentClass.runSharedVariableExperiment();

        System.out.println("\n=== ЭКСПЕРИМЕНТ 2: ЛОКАЛЬНАЯ ПЕРЕМЕННАЯ ===\n");
        ExperimentClass.runLocalVariableExperiment();

        System.out.println("\n=== ЭКСПЕРИМЕНТ 3: СИНХРОНИЗИРОВАННАЯ ОБЩАЯ ===\n");
        ExperimentClass.runSynchronizedExperiment();
    }

    public static void task3() {
        System.out.println("=== МНОГОПОТОЧНЫЙ АНАЛИЗ ТЕКСТА ===\n");

        // Имя файла для анализа (текущая программа)
        String filename = "src/Main.java";

        // Образец для поиска
        String searchPattern = "public";

        // Создаем общую очередь для передачи строк между потоками
        BlockingQueue<String> lineQueue = new LinkedBlockingQueue<>(10);

        // Создаем потоки
        FileReaderThread readerThread = new FileReaderThread(filename, lineQueue);
        LineAnalyzerThread analyzerThread = new LineAnalyzerThread(lineQueue, searchPattern);

        System.out.println("Запуск потоков...\n");

        // Запускаем потоки
        readerThread.start();
        analyzerThread.start();

        // Ждем завершения
        try {
            readerThread.join();
            analyzerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }

    public static void task4() {
        int K = 3;  // количество производителей (>1)
        int M = 2;  // количество потребителей (>1)
        int N = 5;  // размер буфера
        System.out.println("=== КОЛЬЦЕВОЙ БУФЕР (PRODUCER-CONSUMER) ===\n");
        System.out.println("Параметры:");
        System.out.println("  Производителей (K): " + K);
        System.out.println("  Потребителей (M): " + M);
        System.out.println("  Размер буфера (N): " + N);
        System.out.println("  Производитель: в среднем 10 значений, медленнее в 10 раз");
        System.out.println("  Потребитель: быстрее в 10 раз\n");

        // Создаем кольцевой буфер
        CircularBuffer<Integer> buffer = new CircularBuffer<>(N);

        // Создаем пулы потоков
        ExecutorService producerPool = Executors.newFixedThreadPool(K);
        ExecutorService consumerPool = Executors.newFixedThreadPool(M);

        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();

        // Запускаем производителей
        System.out.println("--- ЗАПУСК ПРОИЗВОДИТЕЛЕЙ ---");
        for (int i = 1; i <= K; i++) {
            Producer producer = new Producer(buffer, i);
            producers.add(producer);
            producerPool.submit(producer);
        }

        // Небольшая пауза, чтобы производители начали работу
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Запускаем потребителей
        System.out.println("\n--- ЗАПУСК ПОТРЕБИТЕЛЕЙ ---");
        for (int i = 1; i <= M; i++) {
            Consumer consumer = new Consumer(buffer, i);
            consumers.add(consumer);
            consumerPool.submit(consumer);
        }

        // Ждем завершения производителей
        producerPool.shutdown();
        try {
            if (!producerPool.awaitTermination(30, TimeUnit.SECONDS)) {
                producerPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            producerPool.shutdownNow();
        }

        System.out.println("\n--- ПРОИЗВОДИТЕЛИ ЗАВЕРШИЛИ РАБОТУ ---");
        System.out.println("Ожидаем обработки оставшихся элементов...");

        // Даем потребителям время обработать оставшиеся элементы
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Останавливаем потребителей
        consumerPool.shutdownNow();
        try {
            if (!consumerPool.awaitTermination(5, TimeUnit.SECONDS)) {
                consumerPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            consumerPool.shutdownNow();
        }

        System.out.println("\n=== ИТОГИ РАБОТЫ ===");

        int totalProduced = producers.stream()
                .mapToInt(p -> {
                    try {
                        // Небольшой хак для получения количества
                        java.lang.reflect.Field field = Producer.class.getDeclaredField("producedCount");
                        field.setAccessible(true);
                        return field.getInt(p);
                    } catch (Exception e) {
                        return 0;
                    }
                })
                .sum();

        int totalConsumed = consumers.stream()
                .mapToInt(c -> {
                    try {
                        java.lang.reflect.Field field = Consumer.class.getDeclaredField("consumedCount");
                        field.setAccessible(true);
                        return field.getInt(c);
                    } catch (Exception e) {
                        return 0;
                    }
                })
                .sum();

        System.out.println("Всего произведено: " + totalProduced);
        System.out.println("Всего потреблено: " + totalConsumed);
        System.out.println("Осталось в буфере: " + buffer.getCount());
        System.out.println("\n=== ПРОГРАММА ЗАВЕРШЕНА ===");
    }
}
