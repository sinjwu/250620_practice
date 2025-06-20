class SumRunnable implements Runnable {
    private final int[] numbers;
    public SumRunnable(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        int sum = 0;
        for(int n: numbers) {
            sum += n;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Sum: " + sum);
    }
}

public class MainArrSum0 {
    public static void main(String[] args) {
        int[][] dataSets = {
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {7, 14, 21, 28},
                {100, 200, 300, 400}
        };
        for(int i = 0; i < dataSets.length; i++) {
            Thread sumThread = new Thread(new SumRunnable(dataSets[i]));
            sumThread.start();
        } //for문으로 스레드 계속 생성
        System.out.println("All threads started.");
    }
}
