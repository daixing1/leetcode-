package CreateAnnotations;

import java.lang.annotation.*;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 15:51
 * Description: No Description
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Info {
    String value() default "tracy";
    boolean isDelete();
}
