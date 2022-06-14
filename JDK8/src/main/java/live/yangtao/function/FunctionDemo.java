package live.yangtao.function;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author yangtao
 * @description 函数型接口
 * @create 2022-06-15 2:33
 */
public class FunctionDemo {

    @Test
    public void test1() {
        System.out.println(handle(100.9, new Function<Double, String>() {
            @Override
            public String apply(Double aDouble) {
                return aDouble + "";
            }
        }));

        System.out.println(handle(100.8, p2 -> {
            return p2 + "%";
        }));

    }

    // 处理传进来的Double为Integer
    public String handle(Double d, Function<Double, String> function) {
        return function.apply(d);
    }

}
