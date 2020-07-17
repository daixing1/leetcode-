package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 17:59
 * Description: No Description
 */
public class OuterClass {

    public static void main(String[] args) {
        List<OuterClass> list = new ArrayList<>();
        while (true){
            list.add(new OuterClass());
        }
    }
    private static int a = 0;
    private void foo() {
        InnerClass innerClass = new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }

    public class InnerClass {
        public void add(){
            foo();

        }
    }

    public static class StaticInnerClass {
        public void add(){

        }
    }
}

