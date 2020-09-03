package two;

public class Factory {
    public static Fruit getInstance(String className) {
        Fruit fruit = null;
        //通过反射实例化,子类对象可以使用Fruit来接收
        try {
            fruit = (Fruit) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
