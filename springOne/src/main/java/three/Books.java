package three;

import java.lang.reflect.Field;

public class Books {
    private String name;

    public static void main(String[] args)throws Exception{
        Class<?> cls = Class.forName("three.Books");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Field name = cls.getDeclaredField("name");
        //取消封装
        name.setAccessible(true);
        name.set(obj,"spring框架");
        System.out.println(name.get(obj));
    }
}
