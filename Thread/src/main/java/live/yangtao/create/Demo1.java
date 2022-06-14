package live.yangtao.create;

import org.junit.Test;

/**
 * @author yangtao
 * @description 多线程的创建
 * @create 2022-06-04 4:28
 */
public class Demo1 {

    /**
     * 方法一
     *  1. 自定义类继承Thread类
     *  2. 重写run方法
     *  3. 创建自定义类的子类对象
     *  4. 子类对象调start方法
     */
    @Test
    public void test1() {
        MyThread1 thread1 = new MyThread1();
        MyThread1 thread2 = new MyThread1();
        thread1.run();  // 普通的对象调方法，没有开启新线程
        thread1.start();
        thread2.start();
    }

    /**
     * 方法二
     *  1. 自定义类实现runnable接口
     *  2. 重写run方法
     *  3. 通过自定义类类的实例对象创建线程对象
     */
    @Test
    public void test2() {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2);
        Thread t2 = new Thread(myThread2);
        t1.start();
        t2.start();
    }

    /*
    方法二好处：没有类单继承的限制，且适合处理多个线程有共享数据的情况
     */

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": hello world");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": hello world");
    }
}