package lab5.task2;

import java.util.Random;
import java.util.Vector;

// Вторая нить - Reader (читает значения)
public class ReaderThread extends Thread {
    private final Vector<Float> vector;
    private final Random random = new Random();

    public ReaderThread(Vector<Float> vector) {
        this.vector = vector;
        this.setName("Reader-Thread");
    }

    @Override
    public void run() {
        System.out.println("[" + getName() + "] Поток-читатель запущен, приоритет: " + getPriority());

        for (int i = 0; i < vector.size(); i++) {
            double value;

            // Синхронизация для безопасного чтения
            synchronized (vector) {
                // Ждем, пока писатель запишет значение (не ноль)
                while (Float.compare(vector.get(i), 0.0F) <= 0) {
                    try {
                        System.out.println("[" + getName() + "] Ожидание записи в позиции " + i);
                        vector.wait(1000); // Ждем с таймаутом
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                value = vector.get(i);
                System.out.println("[" + getName() + "] Read: " + String.format("%.2f", value) +
                        " from position " + i);
            }

            // Небольшая задержка для наглядности
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("[" + getName() + "] Поток-читатель завершил работу");
    }
}