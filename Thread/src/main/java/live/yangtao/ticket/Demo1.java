package live.yangtao.ticket;

/**
 * @author yangtao
 * @description 经典案例：卖票（Thread方式开启多线程）
 * @create 2022-06-04 13:30
 */
public class Demo1 {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();

        window1.start();
        window2.start();
        /*
         * 问题：new了多个对象，每个对象都有5张票，总共卖了 N * 100 张票
         * 解决：将实例变量设置为静态变量
         */

    }
}

class Window extends Thread {

//    private int tickets = 100;
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " 卖出了第 " + (100 - (--tickets)) + " 张票");
            } else {
                break;
            }
        }
    }
}
