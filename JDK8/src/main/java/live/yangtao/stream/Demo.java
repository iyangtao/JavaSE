package live.yangtao.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author yangtao
 * @description 测试StreamAPI
 * @create 2022-06-15 2:19
 */
public class Demo {

    private static List<Person> list = null;

    static {
        list = initList();
    }

    /**
     * Stream流的创建
     */
    @Test
    public void test1() {
        // 通过集合类创建
        Stream<Integer> listStream = Collections.singleton(1).stream();
        // 通过数据创建
        IntStream arrayStream = Arrays.stream(new int[] {1, 2, 3});
        // 通过Stream类创建
        Stream<Integer> streamStream = Stream.of(1, 2, 3);
    }

    /**
     * Stream流的种类
     */
    @Test
    public void test2() {
        // 串行流
        Stream<Integer> serialStream = Collections.singleton(1).stream();
        // 并行流
        Stream<Integer> parallelStream = Collections.singleton(1).parallelStream();
        // 无限流
        Stream<Integer> iterateStream = Stream.iterate(1, s -> s + 1);
    }

    /**
     * 筛选与切片
     */
    @Test
    public void test3() {
        List<Person> list = initList();
        Stream<Person> stream = list.stream()
                .distinct()
                .filter(p -> p.getAge() > 10)
                .skip(2)
                .limit(5);

    }

    /**
     * 排序
     */
    @Test
    public void test4() {
        Stream<Integer> stream1 = Stream.of(2, 1, 5, 0, 3)
                .sorted();  // 0, 1, 2, 3, 5

        List<Person> list = initList();
        Stream<Person> stream2 = list.stream()
                .sorted(Comparator.comparingInt(Person::getAge));
    }

    @Test
    public void test5() {
        List<Person> list = initList();
        Stream<Integer> ageStream1 = list.stream()
                .map(Person::getAge);
        IntStream ageStream2 = list.stream()
                .mapToInt(Person::getAge);

        Stream<String> hobbyStream = list.stream()
                .flatMap(p -> p.getHobbies().stream())
                .distinct();
        hobbyStream.forEach(s -> System.out.print(s + " "));
    }

    @Test
    public void test6() {
        List<Person> list = initList();
        boolean b1 = list.stream()
                .allMatch(p -> p.getAge() > 20);
        boolean b2 = list.stream()
                .anyMatch(p -> p.getAge() > 20);
        boolean b3 = list.stream()
                .noneMatch(p -> p.getAge() > 20);
    }

    @Test
    public void test7() {
        List<Person> list = initList();
        long count = list.stream()
                .count();
        Optional<Person> maxAgePerson = list.stream()
                .max(Comparator.comparingInt(Person::getAge));
        Optional<Person> minAgePerson = list.stream()
                .max(Comparator.comparingInt(Person::getAge));
    }

    @Test
    public void test8() {
        List<Person> list = initList();
        list.stream()
                .forEach(System.out::println);
    }

    @Test
    public void test9() {
        Integer sum1 = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce(2, Integer::sum);       // 23
        Optional<Integer> sum2 = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce(Integer::sum);                  // 21
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = list1.parallelStream()
                .reduce(list2,
                        (l1, l2) -> {
                            ArrayList<Integer> tempList = new ArrayList<>(l1);
                            tempList.add(l2);
                            return tempList;
                        },
                        (l1, l2) -> {
                            ArrayList<Integer> tempList = new ArrayList<>(l1);
                            tempList.addAll(l2);
                            System.out.println(tempList);
                            return tempList;
                        });
        System.out.println();
        System.out.println(list3);
    }

    @Test
    public void test10() {
        List<Person> personList = initList();
        List<Person> list = personList.stream()
                .collect(Collectors.toList());
        Set<Person> set = personList.stream()
                .collect(Collectors.toSet());
        LinkedList<Person> linkedList = personList.stream()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Test
    public void test11() {
        int[] rank = {1};
        List<Person> list = initList();
        Stream<Person> stream = list.stream()
                .peek(p -> p.setRank(rank[0]++));
        stream.forEach(System.out::println);
    }

    public static List<Person> initList() {
        Person zs = new Person("002", "zs", 15, Arrays.asList("篮球", "足球"), 0);
        Person ls = new Person("001", "ls", 12, Arrays.asList("围棋", "足球"), 0);
        Person ww = new Person("005", "ww", 16, Arrays.asList("棒球", "唱歌"), 0);
        Person zl = new Person("004", "zl", 12, Arrays.asList("篮球", "桌球"), 0);
        Person tq = new Person("003", "tq", 13, Arrays.asList("健身", "网游"), 0);
        Person zb = new Person("006", "zb", 18, Arrays.asList("游泳", "足球"), 0);
        return Arrays.asList(zs, ls, ww, zl, tq, zb);
    }

}
