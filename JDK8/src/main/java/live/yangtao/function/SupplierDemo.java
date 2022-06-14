package live.yangtao.function;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author yangtao
 * @description 供给型函数
 * @create 2022-06-15 2:28
 */
public class SupplierDemo {

    @Test
    public void test1() {
        System.out.println(getNum(10, new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 20;
            }
        }));

        // return可不写
        System.out.println(getNum(105, () -> 100));

    }

    public int getNum(Integer integer, Supplier<Integer> supplier) {
        return integer * supplier.get();
    }

}
