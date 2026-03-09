package lab6.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileReaderThread extends Thread {
    private final String filename;
    private final BlockingQueue<String> lineQueue;
    private volatile boolean finished = false;

    public FileReaderThread(String filename, BlockingQueue<String> lineQueue) {
        this.filename = filename;
        this.lineQueue = lineQueue;
    }

    @Override
    public void run() {
        System.out.println("Поток-читатель запущен. Читаю файл: " + filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                // Добавляем номер строки для контекста
                String lineWithNumber = lineNumber + ":" + line;

                // Помещаем строку в очередь (блокируется если очередь полна)
                lineQueue.put(lineWithNumber);

                // Небольшая задержка для наглядности
                Thread.sleep(50);
            }

            // Сигнализируем о завершении чтения
            lineQueue.put("EOF");

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            try {
                lineQueue.put("ERROR:" + e.getMessage());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException e) {
            System.err.println("Поток-читатель прерван");
            Thread.currentThread().interrupt();
        } finally {
            finished = true;
            System.out.println("Поток-читатель завершил работу");
        }
    }

    public boolean isFinished() {
        return finished;
    }
}