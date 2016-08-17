package kode.boot.testjar.util;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stark on 2016/8/17.
 *
 * @author Stark
 * @since 1.0
 */
public class ObjectUtils {
    public static Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null)
            return map;

        //TODO: 完善从对象属性提取
        Field[] fields = obj.getClass().getFields();

        return map;
    }
}
