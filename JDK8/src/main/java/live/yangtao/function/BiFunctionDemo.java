package live.yangtao.function;

import org.junit.Test;

import java.util.function.BiFunction;

/**
 * @author yangtao
 * @description 可以看做是两个参数的Function
 * @create 2022-06-15 2:49
 */
public class BiFunctionDemo {

    @Test
    public void test1() {
        StringBuilder handle = handle("hello", "world", new BiFunction<String, String, StringBuilder>() {
            @Override
            public StringBuilder apply(String s, String s2) {
                return new StringBuilder(s).append(" ").append(s2);
            }
        });
        System.out.println(handle.toString());

        System.out.println(handle("hello", "world", (s1, s2) -> {
            return new StringBuilder(s1).append(" ").append(s2);
        }).toString());
    }

    public StringBuilder handle(String s1, String s2, BiFunction<String, String, StringBuilder> biFunction) {
        return biFunction.apply(s1, s2);
    }
}
