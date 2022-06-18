package live.yangtao.reference;

import org.junit.Test;

import java.util.function.BiFunction;

/**
 * @author yangtao
 * @description 类::实例方法名
 * @create 2022-06-18 3:01
 */
public class Demo3 {

    @Test
    public void test1() {
        BiFunction<Person, Person, Integer> biFunction1 = new BiFunction<Person, Person, Integer>() {
            @Override
            public Integer apply(Person p1, Person p2) {
                return p1.ageDiff(p2);
            }
        };

        BiFunction<Person, Person, Integer> biFunction2 = (p1, p2) -> p1.ageDiff(p2);

        BiFunction<Person, Person, Integer> biFunction3 = Person::ageDiff;

        Person zs = new Person("zs", 14, "001");
        Person ls = new Person("ls", 16, "001");
        System.out.println(biFunction3.apply(zs, ls));
    }

}
