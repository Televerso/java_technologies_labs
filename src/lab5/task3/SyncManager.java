package lab5.task3;

import java.util.Vector;

public class SyncManager {
    private boolean canWrite = true;
    private boolean canRead = false;
    private int currentIndex = 0;
    private int vectorSize;

    public SyncManager(int size) {
        this.vectorSize = size;
    }

    public synchronized void waitForWrite(int index) throws InterruptedException {
        while (!canWrite || index != currentIndex) {
            wait();
        }
    }

    public synchronized void waitForRead(int index) throws InterruptedException {
        while (!canRead || index != currentIndex) {
            wait();
        }
    }

    public synchronized void writeDone() {
        canWrite = false;
        canRead = true;
        notifyAll();
    }

    public synchronized void readDone() {
        canWrite = true;
        canRead = false;
        currentIndex++;
        notifyAll();
    }

    public boolean hasMoreElements() {
        return currentIndex < vectorSize;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}