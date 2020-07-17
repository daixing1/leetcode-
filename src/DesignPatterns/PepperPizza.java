package DesignPatterns;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 19:21
 * Description: No Description
 */
public class PepperPizza extends Pizza{
    private String taste;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "PepperPizza{" +
                "taste='" + taste + '\'' +
                '}';
    }
}
