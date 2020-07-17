package jdkProxy;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 17:19
 * Description: No Description
 */
public interface UserService {

    void addUser(User user);

    boolean delUserByName(String name);
}
