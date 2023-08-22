public class OOPS {
    public static void main(String[] args) {
//        Pen p1= new Pen();
//        p1.setColor("blue");
//        p1.setTip(5);
//        System.out.println(p1.color);
//        p1.color="Brown";
//        System.out.println(p1.color);
//        System.out.println(p1.tip=10);
//        System.out.println(p1.tip);
//        BankAccount c1=new BankAccount();
//        c1.username="Chirag_Hooda";
//        c1.setPassword("abcxyz");
//        System.out.println(c1.username);
//        c1.getPasswaord();
//        Student s1=new Student();
//        Student s2= new Student("Chirag");
//        Student s3=new Student(29);
        Student s1=new Student();
        s1.marks=new int[3];
        s1.marks[0]=100;
        s1.marks[1]=95;
        s1.marks[2]=99;
        s1.name="Chirag";
        s1.roll_no=29;
        Student s2=new Student(s1);//copy
        s1.marks[1]=100;
        for(int i=0;i<s2.marks.length;i++){
            System.out.println(s2.marks[i]);
        }
    }
}

class BankAccount{
    public String username;
    private String password;
    //if we write only till here then we can't access password outside this class
    // that's why we use getters and setters
    public void setPassword(String pwd){
        password=pwd;
    }
    public void getPasswaord(){
        System.out.println(password);
    }
}

class Student{
    String name;
    int roll_no;
    int marks[];
    //shallow copy constructor
    //even after copying if we change some value in s1 it gets reflected in s2
//    Student(Student s1){
//        marks = new int[3];
//        this.marks=s1.marks;
//        this.name=s1.name;
//        this.roll_no=s1.roll_no;
//    }
    //deep copy constructor
    //after copying if we change some value in s1 it doesn't get reflected in s2
    Student(Student s1){
        marks = new int[3];
        this.name=s1.name;
        this.roll_no=s1.roll_no;
        for(int i=0;i<s1.marks.length;i++){
            this.marks[i]=s1.marks[i];
        }
    }
    Student(){// this is a constructor if we don't define it then the programme itself created
        // on but it's like this one the on with no parameters not like the other two
        // but once we have created a constructor then programme will not make any
        // constructor on it's own
        System.out.println("constructor is called");
    }
    Student(String name){
        this.name=name;
    }
    Student(int roll_no){
        this.roll_no=roll_no;
    }
}

class Pen{
    String color;
    int tip;
    void setColor(String color){//Setters
        this.color= color;  // this.color represents the color variable of Pen and
                            // color represents to the variable of function
    }
    void setTip(int tip){//Setters
        this.tip=tip;
    }

    String getColor(){//Getters
        return color;
    }

    int getTip(){//Getters
        return tip;
    }
}
