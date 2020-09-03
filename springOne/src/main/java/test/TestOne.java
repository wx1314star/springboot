package test;

import entity.Emp;

import java.lang.annotation.ElementType;

public class TestOne {

    public static void main(String[] args) throws ClassNotFoundException {
        //1.创建对象
        Emp emp = new Emp();

//        emp.setId(1);
//        emp.setAge(20);
//        emp.setGender("男");
//        emp.setName("范志林");
//        emp.setSalary(5000);
//        System.out.println(emp);

        //2.利用反射创建对象
//        Class c1 = Emp.class;
//        Class c2 = Comparable.class;
//        Class c3 = String[].class;
//        Class c4 = String[][].class;
//        Class c5 = ElementType.class;
//        Class c6 = Override.class;
//        Class c7 = Integer.class;
//        Class c8 = void.class;
//
//        System.out.println(c1);
//        System.out.println(c2);
//        System.out.println(c3);
//        System.out.println(c4);
//        System.out.println(c5);
//        System.out.println(c6);
//        System.out.println(c7);
//        System.out.println(c8);

        int[] a=new int[10];
        int[] b=new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
