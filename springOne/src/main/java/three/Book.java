package three;

import java.lang.reflect.Method;

public class Book {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static void main(String[] args) throws Exception {
        String filedName = "title";
        Class<?> cls = Class.forName("three.Book");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method setT = cls.getMethod("set" + convert(filedName), String.class);
        Method getT = cls.getMethod("get" + convert(filedName));
        setT.invoke(obj, "颈椎病康复指南");
        System.out.println(getT.invoke(obj));
    }


    public static String convert(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
