package base_OOP;

public class Cat extends Animal{

    static int countOfCats = 0;

    public Cat(String name){
        this.name = name;
        countOfCats++;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(this + name + " deleted!");
    }

    @Override
    public void say() {
        System.out.println("MEOW!");
    }
}
