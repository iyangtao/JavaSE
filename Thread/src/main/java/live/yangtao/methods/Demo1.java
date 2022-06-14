package live.yangtao.methods;

/**
 * @author yangtao
 * @description
 * @create 2022-06-04 5:06
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        // 设置&获取线程优先级：1-10的数字，默认5，调大只是几率变大，并非严格按优先级执行
        t1.setPriority(Thread.MAX_PRIORITY);
        // 启动新线程
        t1.start();
        // 线程插队，t1执行完以后，主线程才继续执行
        t1.join();
        // 线程让步
        Thread.yield();
        // 线程休眠
        Thread.sleep(100);
        // 强行停止此线程
        t1.stop();
        // 线程是否还存活
        t1.isAlive();
        // 获取当前线程（当前为main）
        Thread thread = Thread.currentThread();
        // 获取&设置名称
        thread.setName("t1");
        thread.getName();
    }

}

class MyThread extends Thread {
    @Override
    public void run() {     // run：类继承Thread后通常需要重写该方法
        super.run();
    }
}