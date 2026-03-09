package lab5.task4;

import java.util.Vector;

public class VectorUtils {

    public static <T> Vector<T> synchronizedVector(Vector<T> vector) {
        return new SynchronizedVector(vector);
    }
}
