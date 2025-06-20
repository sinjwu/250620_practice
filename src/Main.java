class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("My Thread: " + i);
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                System.out.println("누가 깨웠어?!"); //(e.getMessage());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        System.out.println("스레드 인터럽트 ㄱㄱ");
        thread.interrupt();

        thread.run();
        System.out.println("나를 막지 마");
    }
}