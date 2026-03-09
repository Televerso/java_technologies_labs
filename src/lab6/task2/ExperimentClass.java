package lab6.task2;

public class ExperimentClass {
    public static void runSharedVariableExperiment() {
        SharedVariableThread thread1 = new SharedVariableThread("Поток-1");
        SharedVariableThread thread2 = new SharedVariableThread("Поток-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runLocalVariableExperiment() {
        LocalVariableThread thread1 = new LocalVariableThread("Поток-1");
        LocalVariableThread thread2 = new LocalVariableThread("Поток-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runSynchronizedExperiment() {
        SynchronizedSharedThread thread1 = new SynchronizedSharedThread("Поток-1");
        SynchronizedSharedThread thread2 = new SynchronizedSharedThread("Поток-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
