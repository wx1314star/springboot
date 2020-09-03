package two;

public class TestFruit {
    public static void main(String[] args) {
        Fruit apple = Factory.getInstance("two.Apple");
        Fruit pear = Factory.getInstance("two.Pear");
        apple.eat();
        pear.eat();
    }
}
