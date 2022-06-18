package live.yangtao.reference;

/**
 * @author yangtao
 * @description
 * @create 2022-06-18 2:29
 */
public class Person {

    private String name;

    private Integer age;

    private String id;

    public static Integer getNominalAge(Integer age) {
        return age + 1;
    }

    public Person() {
    }

    public Person(String name, Integer age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Integer ageDiff(Person p) {
        return Math.abs(p.getAge() - this.getAge());
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
