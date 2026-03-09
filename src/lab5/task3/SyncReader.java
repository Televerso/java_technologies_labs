package lab5.task3;

import java.util.Random;
import java.util.Vector;

public class SyncReader implements Runnable {
    private final Vector<Float> vector;
    private final SyncManager syncManager;
    private final Random random = new Random();
    private final String name;

    public SyncReader(Vector<Float> vector, SyncManager syncManager, String name) {
        this.vector = vector;
        this.syncManager = syncManager;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("[" + name + "] Читатель запущен");

        while (syncManager.hasMoreElements()) {
            try {
                int index = syncManager.getCurrentIndex();

                // Ждем разрешения на чтение
                syncManager.waitForRead(index);

                // Читаем из вектора
                float value = vector.get(index);
                System.out.println("[" + name + "] Read: " + String.format("%.2f", value) +
                        " from position " + index);

                // Небольшая случайная задержка
                Thread.sleep(random.nextInt(200));

                // Сообщаем, что чтение завершено
                syncManager.readDone();

            } catch (InterruptedException e) {
                System.out.println("[" + name + "] Читатель прерван");
                break;
            }
        }

        System.out.println("[" + name + "] Читатель завершил работу");
    }
}
