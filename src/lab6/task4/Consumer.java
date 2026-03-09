package lab6.task4;

import lab6.task4.CircularBuffer;

import java.util.Random;

public class Consumer implements Runnable {
    private final CircularBuffer<Integer> buffer;
    private final int id;
    private final Random random = new Random();
    private int consumedCount = 0;

    public Consumer(CircularBuffer<Integer> buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        String threadName = "Потребитель-" + id;
        Thread.currentThread().setName(threadName);

        System.out.println(threadName + " запущен");

        try {
            // Потребители работают непрерывно, пока есть что потреблять
            while (!Thread.currentThread().isInterrupted()) {
                // Потребитель работает БЫСТРЕЕ (в 10 раз чаще производителя)
                // Поэтому делаем маленькую задержку
                int workTime = 20 + random.nextInt(50); // 20-70 мс
                Thread.sleep(workTime);

                Integer value = buffer.take();
                consumedCount++;

                // Случайная вариация частоты
                if (random.nextInt(10) == 0) {
                    // Иногда работаем медленнее
                    Thread.sleep(100);
                }

                // Проверка на завершение (после того как все производители закончили)
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
                    " завершен. Потреблено: " + consumedCount);
            Thread.currentThread().interrupt();
        }
    }
}