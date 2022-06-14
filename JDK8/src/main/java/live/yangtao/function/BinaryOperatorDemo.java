package live.yangtao.function;

import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * @author yangtao
 * @description 三个参数类型相同的BiFunction
 * @create 2022-06-15 3:01
 */
public class BinaryOperatorDemo {

    @Test
    public void test1() {
        System.out.println(handle("hello ", "world", new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        }));

        System.out.println(handle("hello ", "world", (s1, s2) -> s1 + s2));
    }

    public String handle(String s1, String s2, BinaryOperator<String> binaryOperator) {
        return binaryOperator.apply(s1, s2);
    }
}
