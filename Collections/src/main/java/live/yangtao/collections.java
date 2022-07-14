package live.yangtao;

import org.junit.Test;

import java.util.*;

/**
 * @author yangtao
 * @description
 * @create 2022-07-04 1:24
 */
public class collections {

    private static ArrayList<String> arrayList1;
    private static ArrayList<String> arrayList2;

    static {
        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arrayList1.add(i + "");
        }
        for (int i = 6; i <= 10; i++) {
            arrayList2.add(i + "");
        }
    }

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        // 往集合中添加元素
        Collections.addAll(list, 1, 2);
        // 查找元素的下标
        int i = Collections.binarySearch(list, 2);
        //
        int j = Collections.binarySearch(list, 2, (i1, i2) -> {
            if (i1 > i2) {
                return -1;
            } else if (i1.equals(i2)) {
                return 0;
            } else {
                return 1;
            }
        });

        System.out.println(j);
    }

}
