package live.yangtao.stream;

import lombok.*;

import java.util.List;
import java.util.Objects;

/**
 * @author yangtao
 * @description
 * @create 2022-06-19 1:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {

    private String no;
    private String name;
    private Integer age;
    private List<String> hobbies;
    private Integer rank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return no.equals(person.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
