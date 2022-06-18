package live.yangtao.reference;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yangtao
 * @description 类::静态方法名
 * @create 2022-06-18 2:36
 */
public class Demo2 {
    @Test
    public void test() {
        Function<Integer, Integer> function1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return Person.getNominalAge(i);
            }
        };

        Function<Integer, Integer> function2 = i -> Person.getNominalAge(i);

        Function<Integer, Integer> function3 = Person::getNominalAge;

        System.out.println(function1.apply(2));
        System.out.println(function2.apply(2));
        System.out.println(function3.apply(2));
    }
}
