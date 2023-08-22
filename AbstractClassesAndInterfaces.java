public class AbstractClassesAndInterfaces {
    public static void main(String[] args) {
        Horse h=new Horse();
        h.eat();
        h.walk();
        h.eyes=2;
        Chicken c=new Chicken();
        c.eat();
        c.walk();
        System.out.println(c.eyes);
        Queen q=new Queen();
        q.moves();
    }
}
abstract class Animals{//object of abstract class can not be created
    static int eyes;
    abstract void walk();
    void eat(){
        System.out.println("eats");
    }
}
class Horse extends Animals{
    void walk(){
        System.out.println("walks on 4 legs");
    }
}
class Chicken extends Animals{
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}

interface chessPlayer{
    void moves();
}
class Queen implements chessPlayer{
    public void moves(){
        System.out.println("All directions");
    }
}