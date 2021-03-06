package CreateAnnotations;

import java.util.Date;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 15:52
 * Description: No Description
 */
// 为Person类配置了刚刚定义的注解@Info
@Info(isDelete = false)
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 是否有效
     */
    private boolean isDelete;
}

