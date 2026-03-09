package lab5.task3;

import java.util.Random;
import java.util.Vector;

public class SyncWriter implements Runnable {
    private final Vector<Float> vector;
    private final SyncManager syncManager;
    private final Random random = new Random();
    private final String name;

    public SyncWriter(Vector<Float> vector, SyncManager syncManager, String name) {
        this.vector = vector;
        this.syncManager = syncManager;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("[" + name + "] Писатель запущен");

        // Пишем для каждого индекса
        for (int i = 0; i < vector.size(); i++) {
            try {
                // Ждем разрешения на запись именно для этого индекса
                syncManager.waitForWrite(i);

                // Генерируем случайное число
                float value = random.nextFloat() * 100;
                value = (Float.compare(value, 0.0F) <= 0) ? Float.MIN_VALUE : value;

                // Записываем
                vector.set(i, value);
                System.out.println("[" + name + "] Write: " + String.format("%.2f", value) +
                        " to position " + i);

                Thread.sleep(random.nextInt(200));

                // Сообщаем, что запись завершена
                syncManager.writeDone();

            } catch (InterruptedException e) {
                System.out.println("[" + name + "] Писатель прерван");
                break;
            }
        }

        System.out.println("[" + name + "] Писатель завершил работу");
    }
}