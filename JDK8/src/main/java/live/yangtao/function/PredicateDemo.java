package live.yangtao.function;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author yangtao
 * @description
 * @create 2022-06-15 2:44
 */
public class PredicateDemo {

    @Test
    public void test1() {
        System.out.println(predicate(-1, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        }));

        System.out.println(predicate(1, i -> i > 0));

    }

    public boolean predicate(Integer i, Predicate<Integer> predicate) {
        return predicate.test(i);
    }
}
