package lab5.task2;

import java.util.Random;
import java.util.Vector;

// Первая нить - Writer (записывает значения)
public class WriterThread extends Thread {
    private final Vector<Float> vector;
    private final Random random = new Random();

    public WriterThread(Vector<Float> vector) {
        this.vector = vector;
        this.setName("Writer-Thread");
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Поток-писатель запущен, приоритет: " + getPriority());

        for (int i = 0; i < vector.size(); i++) {
            // Генерируем случайное число (отличное от нуля)
            float value = random.nextFloat() * 100;
            value = (Float.compare(value, 0.0F) <= 0) ? Float.MIN_VALUE : value;

            // Синхронизация для безопасной записи
            synchronized (vector) {
                vector.set(i, value);
                System.out.println("[" + getName() + "] Write: " +  String.format("%.2f", value) +
                        " to position " + i);

                // Уведомляем читателя, что появилось новое значение
                vector.notify();
            }

            // Небольшая задержка для наглядности
            try {
                Thread.sleep(random.nextInt(500)); // 0-500 мс
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + getName() + "] Поток-писатель завершил работу");
    }
}
