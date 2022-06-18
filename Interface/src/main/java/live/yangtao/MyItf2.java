package live.yangtao;

/**
 * @author yangtao
 * @description
 * @create 2022-06-18 17:47
 */
public interface MyItf2 {

    default String getName() {
        return "MyItf2: " + this.getClass().getName();
    }

    default String getName2() {
        return "MyItf22: " + this.getClass().getName();
    }
}
