public class Task1 {
    public static void main(String[] args) {
        Owner owner = new Owner("Стас");
        Cat barsik = new Cat("Барсик", 4, owner);

        barsik.showGreet();
    }
}

class Shaper {
    private String name;
    private int age;

    public Shaper(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Shaper(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

interface Greetings {
    default void greet() {
        System.out.println("Мяу!");
    }
}

interface OwnerInfo {
    String getOwnerName();
}

interface AgeInfo {
    int getAge();
}

interface Constants {
    int CAT_LEG_COUNT = 4;
}

interface Overloads extends Greetings, OwnerInfo, AgeInfo {
    String getName();
    default void showGreet() {
        greet();
        System.out.printf("Меня зовут %s. Мне %d года(лет). Мой владелец - %s.",
                getName(), getAge(), getOwnerName());
    }
}

class Cat extends Shaper implements Overloads, Constants {
    private Owner owner;

    public Cat(String name, int age, Owner owner) {
        super(name, age);
        this.owner = owner;
    }

    @Override
    public String getOwnerName() {
        return owner.getName();
    }
}

class Owner implements OwnerInfo {
    private String name;

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getOwnerName() {
        return name;
    }
}