class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Sync1 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable task = () -> {
            for(int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.println("Final count: " + counter.getCount());
    }
}