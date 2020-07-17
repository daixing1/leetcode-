package DesignPatterns;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 19:24
 * Description: No Description
 */
public class PizzaStore {
    public static void main(String[] args) {
        AbsFactory factory = new WHFactory();
        Pizza pizza = factory.creatPizza("cheese");
        System.out.println(pizza.getClass());
    }
}
