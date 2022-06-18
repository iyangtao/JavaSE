package live.yangtao.reference;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author yangtao
 * @description 对象::实例方法
 * @create 2022-06-18 2:29
 */
public class Demo1 {
    @Test
    public void test1() {
        Person p = new Person("张三", 14, "002");
        // 常规
        Supplier<Integer> supplier1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return p.getAge();
            }
        };
        // lambda
        Supplier<Integer> supplier2 = () -> p.getAge();
        // 方法引用：lambda表达式的形参和返回值与实例方法完全一致
        Supplier<Integer> supplier3 = p::getAge;
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println(supplier3.get());
    }
}
