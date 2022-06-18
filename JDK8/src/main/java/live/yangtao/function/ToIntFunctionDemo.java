package live.yangtao.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * @author yangtao
 * @description 接收T，返回int，类似的有ToLong、ToDouble
 * @create 2022-06-18 1:58
 */
public class ToIntFunctionDemo {

    @Test
    public void test1() {
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(handle(integers, new ToIntFunction<List>() {
            @Override
            public int applyAsInt(List value) {
                return value.size();
            }
        }));

        System.out.println(handle(integers, List::size));
    }

    public int handle(List list, ToIntFunction<List> toIntFunction) {
        return toIntFunction.applyAsInt(list);
    }
}
