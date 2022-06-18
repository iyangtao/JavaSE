package live.yangtao;

import org.junit.Test;

import java.util.Collections;

/**
 * @author yangtao
 * @description
 * @create 2022-06-18 17:24
 */
public class Demo1 extends MyAbstCls implements MyItf2 {

    @Test
    public void test() {
        System.out.println(new Demo1().getName());
    }

}

class MyCls extends MyAbstCls implements MyItf, MyItf2 {



}