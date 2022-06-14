package live.yangtao.function;

import org.junit.Test;

import java.util.function.BiConsumer;

/**
 * @author yangtao
 * @description 两个参数的Consumer
 * @create 2022-06-15 3:05
 */
public class BiConsumerDemo {

    @Test
    public void test1() {
        handle("广州", 100.8, new BiConsumer<String, Double>() {
            @Override
            public void accept(String s, Double aDouble) {
                System.out.println("今天去" + s + "，花了" + aDouble + "块钱");
            }
        });

        handle("Beijing", 100.2, (s, d) -> System.out.println("今天去" + s + "，花了" + d + "块钱"));
    }

    public void handle(String place, Double money, BiConsumer<String, Double> biConsumer) {
        biConsumer.accept(place, money);
    }
}
