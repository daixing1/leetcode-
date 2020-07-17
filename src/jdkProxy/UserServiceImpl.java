package jdkProxy;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 17:19
 * Description: No Description
 */
public class UserServiceImpl implements UserService{
    @Override
    public void addUser(User user) {
        System.out.println(user.toString());
    }

    @Override
    public boolean delUserByName(String name) {
        System.out.println("name: "+name);
        if ("123".equals(name)){
            return true;
        }
        return false;
    }
}
