package lab6.task4;

import lab6.task4.CircularBuffer;

import java.util.Random;

public class Producer implements Runnable {
    private final CircularBuffer<Integer> buffer;
    private final int id;
    private final Random random = new Random();
    private int producedCount = 0;
    private static final int TARGET_PRODUCED = 10; // В среднем 10 значений

    public Producer(CircularBuffer<Integer> buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        String threadName = "Производитель-" + id;
        Thread.currentThread().setName(threadName);

        System.out.println(threadName + " запущен");

        try {
            // Производим в среднем 10 значений (с вариацией)
            int totalToProduce = TARGET_PRODUCED + random.nextInt(5) - 2; // 8-13
            System.out.println(threadName + " планирует произвести " + totalToProduce + " значений");

            for (int i = 0; i < totalToProduce; i++) {
                // Производитель работает МЕДЛЕННЕЕ (в 10 раз реже потребителя)
                // Поэтому делаем большую задержку
                int workTime = 200 + random.nextInt(300); // 200-500 мс
                Thread.sleep(workTime);

                int value = random.nextInt(100);
                buffer.put(value);
                producedCount++;

                // Случайная вариация частоты
                if (random.nextInt(10) == 0) {
                    // Иногда работаем быстрее
                    Thread.sleep(50);
                }
            }

            System.out.println(threadName + " завершил работу. Произведено: " + producedCount);

        } catch (InterruptedException e) {
            System.err.println(threadName + " прерван");
            Thread.currentThread().interrupt();
        }
    }
}