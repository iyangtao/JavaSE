package live.yangtao.reference;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author yangtao
 * @description 类::new
 * @create 2022-06-18 3:08
 */
public class Demo4 {
    @Test
    public void test1() {
        Function<String, Person> function1 = new Function<String, Person>() {
            @Override
            public Person apply(String s) {
                return new Person(s);
            }
        };

        Function<String, Person> function2 = s -> new Person(s);

        Function<String, Person> function3 = Person::new;   // 此处只允许有一个参数为String的构造方法

        System.out.println(function3.apply("ww"));
    }
}
