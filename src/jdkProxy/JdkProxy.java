package jdkProxy;

import java.lang.reflect.Proxy;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 17:20
 * Description: No Description
 */
public class JdkProxy {
    public static void main(String[] args) {
        User user = new User();
        user.setAddress("jkj");
        user.setName("12");
        user.setAge(13);
        UserService userService = new UserServiceImpl();
        UserServiceHandler ush = new UserServiceHandler(userService);
        UserService userService1 = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), ush);
        userService1.addUser(user);
        boolean b = userService1.delUserByName("4567");
        System.out.println(b);
        System.out.println("success");
    }
}
