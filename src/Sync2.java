class Counter2 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Sync2 {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter = new Counter2();
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
        for(Thread t: threads) {
            t.join();
        }
        System.out.println("Final count: " + counter.getCount());
    }
}