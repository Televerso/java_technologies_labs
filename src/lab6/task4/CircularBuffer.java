package lab6.task4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBuffer<T> {
    private final T[] buffer;
    private final int capacity;
    private int head = 0;      // позиция для чтения
    private int tail = 0;      // позиция для записи
    private int count = 0;     // текущее количество элементов

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[capacity];
    }

    // Метод для производителей (запись)
    public void put(T item) throws InterruptedException {
        lock.lock();
        try {
            // Ждем, пока освободится место
            while (count == capacity) {
                System.out.println(Thread.currentThread().getName() +
                        ": буфер полон, ожидание...");
                notFull.await();
            }

            // Записываем элемент
            buffer[tail] = item;
            tail = (tail + 1) % capacity;
            count++;

            System.out.println(Thread.currentThread().getName() +
                    ": записал значение " + item +
                    " [буфер: " + count + "/" + capacity + "]");

            // Сигнализируем потребителям
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    // Метод для потребителей (чтение)
    public T take() throws InterruptedException {
        lock.lock();
        try {
            // Ждем, пока появятся элементы
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() +
                        ": буфер пуст, ожидание...");
                notEmpty.await();
            }

            // Читаем элемент
            T item = buffer[head];
            head = (head + 1) % capacity;
            count--;

            System.out.println(Thread.currentThread().getName() +
                    ": прочитал значение " + item +
                    " [буфер: " + count + "/" + capacity + "]");

            // Сигнализируем производителям
            notFull.signal();

            return item;

        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public boolean isFull() {
        return getCount() == capacity;
    }
}