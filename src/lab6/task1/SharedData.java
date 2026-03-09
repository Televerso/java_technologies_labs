package lab6.task1;

public class SharedData {
    private int count = 0;
    private final int targetValue = 5;

    // Мьютекс (монитор) - это сам объект SharedData
    // Условная переменная - встроенный wait/notify механизм

    public synchronized void incrementAndSignal() {
        count++;
        System.out.println("Поток B: count = " + count);

        // Проверяем условие
        if (count >= targetValue) {
            System.out.println("Поток B: достигнуто целевое значение, отправляю сигнал");
            notify(); // Сигнализируем потоку A
        }
    }

    public synchronized void waitForTarget() throws InterruptedException {
        System.out.println("Поток A: ожидаю count = " + targetValue);

        // Ждем пока count не достигнет targetValue
        while (count < targetValue) {
            System.out.println("Поток A: count = " + count + ", продолжаю ждать");
            wait(); // Блокирующее ожидание (автоматически отпускает монитор)
        }

        // Проснулись и снова захватили монитор
        System.out.println("Поток A: дождался! count = " + count);
    }
}
