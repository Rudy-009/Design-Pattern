public class Main{
    public static void main(String args[]) {
        Apple apple01 = new Apple("01");
        Apple apple02 = (Apple) apple01.clone();

        apple01.info();
        apple02.info();
        apple01.changeName("03");
        apple01.info();
        apple02.info();
    }
}

interface Prototype {
    public Prototype clone();
}

class Apple implements Prototype {
    private String name;

    public Apple(String name) {
        this.name = name;
    }

    public Prototype clone() {
        return new Apple(name);
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void info() {
        System.out.println("name is " + this.name);
    }
}