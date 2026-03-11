package lab5.task1;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Поток Thread #" + Thread.currentThread().threadId() + ": счет = " + i);
            try {
                Thread.sleep(1000); // Пауза 1 секунда
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
        }
    }
}
