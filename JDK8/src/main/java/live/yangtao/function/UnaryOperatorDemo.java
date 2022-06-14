package live.yangtao.function;

import org.junit.Test;

import java.util.function.UnaryOperator;

/**
 * @author yangtao
 * @description 可以看做返回类型相同的Function
 * @create 2022-06-15 2:58
 */
public class UnaryOperatorDemo {

    @Test
    public void test1() {
        System.out.println(handle(1, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        }));

        System.out.println(handle(2, i -> i * 3));
    }

    public int handle(Integer integer, UnaryOperator<Integer> unaryOperator) {
        return unaryOperator.apply(integer);
    }
}
