package lab6.task1;

public class ThreadA extends Thread {
    private SharedData sharedData;

    public ThreadA(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            sharedData.waitForTarget();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
