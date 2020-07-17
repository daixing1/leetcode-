package DesignPatterns;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 19:20
 * Description: No Description
 */
public class CheesePizza extends Pizza{
    private String taste;

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    @Override
    public String toString() {
        return "CheesePizza{" +
                "taste='" + taste + '\'' +
                '}';
    }
}
