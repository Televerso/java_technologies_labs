package lab6.task1;

public class ThreadB extends Thread {
    private SharedData sharedData;

    public ThreadB(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedData.incrementAndSignal();

            try {
                Thread.sleep(500); // Пауза для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
