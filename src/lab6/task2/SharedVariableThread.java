package lab6.task2;

public class SharedVariableThread extends Thread {
    // Общая переменная (приватная, но статическая - общая для всех экземпляров)
    private static int sharedI = 0;
    private String threadName;

    public SharedVariableThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sharedI++; // Инкремент общей переменной
            System.out.println(threadName + ": sharedI = " + sharedI);

            // Небольшая задержка для наглядности
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " завершил работу. Итоговое sharedI = " + sharedI);
    }
}