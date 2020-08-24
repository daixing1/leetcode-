package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/17
 * Time: 11:30
 * Description: No Description
 */
public class E <T> {
    T t ;

    public E(T t) {
        this.t = t;
    }
    public void add(T t){
        this.t =t;
    }
    public static void main(String... args){
        E e = new E("A");
        System.out.println(e.t.getClass());
        e.add(1);
        e.add("123");
        e.add(1);
        System.out.println(e.t.getClass());
    }
}