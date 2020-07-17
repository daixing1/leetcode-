package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 17:21
 * Description: No Description
 */
public class UserServiceHandler implements InvocationHandler {
    private Object ret;

    public Object getRet() {
        return ret;
    }

    public void setRet(Object ret) {
        this.ret = ret;
    }

    public UserServiceHandler(Object obj){
        this.ret = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if ("addUser".equals(method.getName())){
            User user = (User) args[0];
            if (user.getName().length()<2){
                throw new Exception("名字长度不能小于2");
            }
            method.invoke(ret, args);
        }
        if ("delUserByName".equals(method.getName())){
            String name = (String) args[0];
            if ("456".equals(name)){
                throw new Exception("禁止删除456");
            }
            result = method.invoke(ret, args);
        }

        System.out.println("增强完成");
        return result;
    }
}
