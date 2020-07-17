package Serial;

import java.io.Serializable;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 15:27
 * Description: No Description
 */
public class User implements Serializable {
    private String userName;
    private String passWord;
    private String userInfo;
    private List<User> friends;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", friends=" + friends +
                '}';
    }
}
