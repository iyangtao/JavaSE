package live.yangtao.function;

import org.junit.Test;

import java.util.function.BiPredicate;

/**
 * @author yangtao
 * @description 两个参数的Predicate
 * @create 2022-06-18 1:54
 */
public class BiPredicateDemo {

    @Test
    public void test1() {
        System.out.println(handle(1, 2, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer i1, Integer i2) {
                return i1 > i2;
            }
        }));

        System.out.println(handle(1, 2, (i1, i2) -> i1 < i2));
    }

    public boolean handle(Integer i1, Integer i2, BiPredicate<Integer, Integer> predicate) {
        return predicate.test(i1, i2);
    }

}
