package one;

import java.lang.reflect.Constructor;

public class Book {
    private String id;
    private String name;

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args)throws Exception{
        Class<?> cls = Class.forName("one.Book");
        Constructor<?> constructor = cls.getConstructor(String.class, String.class);
        Object obj = constructor.newInstance("1", "Java从入门到入坟");
        System.out.println(obj);
    }
}
