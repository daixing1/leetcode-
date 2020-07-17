package DesignPatterns;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 19:23
 * Description: No Description
 */
public class WHFactory extends AbsFactory{
    @Override
    public Pizza creatPizza(String s) {
        if ("cheese".equals(s)){
            return new CheesePizza();
        }else if ("pepper".equals(s)){
            return new PepperPizza();
        }
        return null;
    }
}
