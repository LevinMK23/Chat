package base_OOP;

public class Dog extends Animal{

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println(String.format("My name is %s, WOW", name));
    }
}
