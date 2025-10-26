package util;

public class Timer {
    private long start;

    public void start() {
        start = System.nanoTime();
    }

    public double elapsedMillis() {
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; // ns to ms as double
    }
}