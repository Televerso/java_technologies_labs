package lab6.task3;

import java.util.concurrent.BlockingQueue;

public class LineAnalyzerThread extends Thread {
    private final BlockingQueue<String> lineQueue;
    private final String searchPattern;
    private int processedLines = 0;
    private int matchedLines = 0;

    public LineAnalyzerThread(BlockingQueue<String> lineQueue, String searchPattern) {
        this.lineQueue = lineQueue;
        this.searchPattern = searchPattern;
    }

    @Override
    public void run() {
        System.out.println("Поток-анализатор запущен. Ищу образец: \"" + searchPattern + "\"");
        System.out.println("--- Результаты анализа ---");

        try {
            while (true) {
                // Получаем строку из очереди (блокируется если очередь пуста)
                String lineWithNumber = lineQueue.take();

                // Проверяем на сигнал окончания
                if ("EOF".equals(lineWithNumber)) {
                    break;
                }

                // Проверяем на ошибку
                if (lineWithNumber.startsWith("ERROR:")) {
                    System.err.println("Получена ошибка: " + lineWithNumber);
                    continue;
                }

                processedLines++;

                // Разделяем номер строки и содержимое
                int colonIndex = lineWithNumber.indexOf(':');
                String lineNumber = lineWithNumber.substring(0, colonIndex);
                String lineContent = lineWithNumber.substring(colonIndex + 1);

                // Анализируем вхождение образца
                if (lineContent.contains(searchPattern)) {
                    matchedLines++;
                    System.out.println("  [Строка " + lineNumber + "] " + lineContent);
                }

                // Небольшая задержка для наглядности
                Thread.sleep(20);
            }

        } catch (InterruptedException e) {
            System.err.println("Поток-анализатор прерван");
            Thread.currentThread().interrupt();
        }

        System.out.println("--- Анализ завершен ---");
        System.out.println("Всего обработано строк: " + processedLines);
        System.out.println("Найдено совпадений: " + matchedLines);
        System.out.println("Поток-анализатор завершил работу");
    }
}