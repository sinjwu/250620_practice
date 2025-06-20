class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable2 실행 중");

        for(int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(5000);
                System.out.println(i);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class Mainct {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable2(),"CountThread");
        thread.start();
        System.out.println(thread.getName());
    }
}