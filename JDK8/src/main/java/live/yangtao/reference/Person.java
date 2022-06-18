package live.yangtao.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangtao
 * @description
 * @create 2022-06-18 2:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private String id;

    public static Integer getNominalAge(Integer age) {
        return age + 1;
    }

    public Integer ageDiff(Person p) {
        return Math.abs(p.getAge() - this.getAge());
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge(Person person) {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
