package lab6.task2;

public class LocalVariableThread extends Thread {
    private String threadName;

    public LocalVariableThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        // Локальная переменная в методе run() - своя для каждого потока
        int localI = 0;

        for (int i = 0; i < 100; i++) {
            localI++; // Инкремент локальной переменной
            System.out.println(threadName + ": localI = " + localI);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " завершил работу. Итоговое localI = " + localI);
    }
}