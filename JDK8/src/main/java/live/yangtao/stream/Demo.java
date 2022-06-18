package live.yangtao.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author yangtao
 * @description 测试StreamAPI
 * @create 2022-06-15 2:19
 */
public class Demo {

    @Test
    public void test() {
        List<Person> personList = initList();
        int[] rankArr = {0};
        personList.stream()
                .filter(p -> p.getAge() < 18)
                .distinct()
                .limit(10)
                .skip(0)
                .sorted(Comparator.comparing(Person::getAge))
                .peek(person -> person.setRank(++rankArr[0]))
                .sorted(Comparator.comparing(Person::getRank))
                .forEach(System.out::println);

    }

    public List<Person> initList() {
        Person zs = new Person("002", "zs", 15, Arrays.asList("篮球", "足球"), 0);
        Person ls = new Person("001", "ls", 12, Arrays.asList("围棋", "足球"), 0);
        Person ww = new Person("005", "ww", 16, Collections.singletonList("棒球"), 0);
        Person zl = new Person("004", "zl", 12, Arrays.asList("篮球", "桌球"), 0);
        Person tq = new Person("003", "tq", 13, Arrays.asList("健身", "网游"), 0);
        Person zb = new Person("006", "zb", 18, Arrays.asList("游泳", "足球"), 0);
        return Arrays.asList(zs, ls, ww, zl, tq, zb);
    }

}
