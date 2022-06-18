package live.yangtao.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author yangtao
 * @description
 * @create 2022-06-18 2:11
 */
public class IntFunctionDemo {
    @Test
    public void test1() {
        System.out.println(handle(4, new IntFunction<List>() {
            @Override
            public List apply(int value) {
                return Arrays.asList(value, value);
            }
        }));

        System.out.println(handle(2, i -> Arrays.asList(i, i)));
    }

    public List handle(int size, IntFunction<List> intFunction) {
        return intFunction.apply(size);
    }
}
