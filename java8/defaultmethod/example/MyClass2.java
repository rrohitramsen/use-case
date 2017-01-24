package java8.defaultmethod.example;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class MyClass2 implements Interface1 {

    @Override
    public void method1(String str) {
        System.out.println("MyClass2 method1()");
    }

    public static void main(String[] args) {

        MyClass2  myClass2 = new MyClass2();
        myClass2.log(myClass2.getClass().getName());
        Interface2.logStatic(myClass2.getClass().getCanonicalName());
    }
}
