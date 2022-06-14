package live.yangtao.ticket;

import org.junit.Test;

/**
 * @author yangtao
 * @description
 * @create 2022-06-04 14:02
 */
public class Demo2 {

    public static void main(String[] args) {
        WindowPlus windowPlus = new WindowPlus();
        Thread t1 = new Thread(windowPlus);
        Thread t2 = new Thread(windowPlus);
        Thread t3 = new Thread(windowPlus);
        t1.start();
        t2.start();
        t3.start();
    }

}

class WindowPlus implements Runnable {

    private int tickets = 1000;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + (1000 - (--tickets)) + " 张票");
            } else {
                break;
            }
        }
    }
}