package lab6.task2;

public class SynchronizedSharedThread extends Thread {
    private static int sharedI = 0;
    private static final Object lock = new Object(); // Объект для синхронизации
    private String threadName;

    public SynchronizedSharedThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // Синхронизированный блок
            synchronized (lock) {
                sharedI++;
                System.out.println(threadName + " (sync): sharedI = " + sharedI);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " завершил работу. Итоговое sharedI = " + sharedI);
    }
}