class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable 실행 중");

        for(int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(500);
                System.out.println(i);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class MainRun {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
