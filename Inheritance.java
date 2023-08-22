public class Inheritance {
    public static void main(String[] args) {
        //Single Level Inheritance
//        System.out.println("Single Level Inheritance");
//        Fish shark=new Fish();
//        shark.eat();
//        shark.color="grey";
//        shark.breathe();
//        shark.fins=16;
//        shark.swim();
        //Multi-level Inheritance
//        System.out.println("Multi-level inheritance");
//        Dog max=new Dog();
//        max.breed="labra";
//        max.color="Golden";
//        max.eat();
//        max.breathe();
//        max.legs=4;
//        System.out.println(max.legs);
        //Hybrid Inheritance
        Shark s=new Shark();
        s.fins=16;
        s.eat();
        System.out.println(s.fins);
        Peakock p=new Peakock();
        p.fly();
        p.beak_size="average";
        System.out.println(p.beak_size);
        Human h=new Human();
        h.legs=2;
        h.age=18;
        System.out.println(h.legs+","+h.age);
    }
}
//Base
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    }
}
//SINGLE LEVEL INHERITANCE
//Derived
//class Fish extends Animal{
//    //color="blue";  gives error
//    int fins;
//    void swim(){
//        System.out.println("swims in water");
//    }
//}
////MULTI-LEVEL INHERITANCE
//class Mammals extends Animal{
//    int legs;
//}
//class Dog extends Mammals{
//    String breed;
//}

//Hybrid Inheritance
class Fish extends Animal{
    int fins;
}
class Tuna extends Fish{
    void swim(){
        System.out.println("Swims fairly below water");
    }
}
class Shark extends Fish{
    void swim(){
        System.out.println("Swims very deep in the sea");
    }
}
class Bird extends Animal{
    String beak_size;
}
class Peakock extends Bird{
    void fly(){
        System.out.println("Males can fly but female can't");
    }
}
class Mammals extends Animal{
    int legs;
}
class dog extends Mammals{
    String breed;
}
class cat extends Mammals{
    String color;
}
class Human extends Mammals{
    int age;
}