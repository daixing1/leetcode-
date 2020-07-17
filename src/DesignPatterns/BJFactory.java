package DesignPatterns;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 19:19
 * Description: No Description
 */
public class BJFactory extends AbsFactory{
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
