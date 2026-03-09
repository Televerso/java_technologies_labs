package lab5.task4;

import java.util.Enumeration;
import java.util.Vector;

public class SynchronizedVector extends Vector {
    private final Vector wrappedVector;
    private final Object mutex = new Object();

    public SynchronizedVector(Vector vector) {
        this.wrappedVector = vector;
    }

    // Переопределение методов Vector с синхронизацией

    @Override
    public int size() {
        synchronized (mutex) {
            return wrappedVector.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (mutex) {
            return wrappedVector.isEmpty();
        }
    }

    @Override
    public Enumeration elements() {
        synchronized (mutex) {
            return wrappedVector.elements();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (mutex) {
            return wrappedVector.contains(o);
        }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (mutex) {
            return wrappedVector.indexOf(o);
        }
    }

    @Override
    public Object get(int index) {
        synchronized (mutex) {
            return wrappedVector.get(index);
        }
    }

    @Override
    public Object set(int index, Object element) {
        synchronized (mutex) {
            return wrappedVector.set(index, element);
        }
    }

    @Override
    public boolean add(Object o) {
        synchronized (mutex) {
            return wrappedVector.add(o);
        }
    }

    @Override
    public void add(int index, Object element) {
        synchronized (mutex) {
            wrappedVector.add(index, element);
        }
    }

    @Override
    public Object remove(int index) {
        synchronized (mutex) {
            return wrappedVector.remove(index);
        }
    }

    @Override
    public boolean remove(Object o) {
        synchronized (mutex) {
            return wrappedVector.remove(o);
        }
    }

    @Override
    public void clear() {
        synchronized (mutex) {
            wrappedVector.clear();
        }
    }

    // Переопределение методов Object

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        synchronized (mutex) {
            if (!(obj instanceof SynchronizedVector)) return false;
            SynchronizedVector other = (SynchronizedVector) obj;
            return wrappedVector.equals(other.wrappedVector);
        }
    }

    @Override
    public int hashCode() {
        synchronized (mutex) {
            return wrappedVector.hashCode();
        }
    }

    @Override
    public String toString() {
        synchronized (mutex) {
            return "SynchronizedVector{" + wrappedVector.toString() + "}";
        }
    }
}