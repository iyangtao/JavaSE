package live.yangtao.function;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author yangtao
 * @description 测试函数式接口
 * @create 2022-06-15 2:21
 */
public class ConsumerDemo {

    // 消费型
    @Test
    public void test1() {
        // 重写接口
        shopping(100.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });

        // lambda表达式
        shopping(100, money -> System.out.println(money));

        // 方法引用
        shopping(100, System.out::println);
    }

    public void shopping(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

}
