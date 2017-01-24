package java8.defaultmethod.example;

/**
 * Created by rohitkumar on 24/01/17.
 */
public interface Interface2 {

    void method2();

    default void log(String str){
        System.out.println("Interface-2 logging::"+str);
    }

    static void logStatic(String str) {
        System.out.println("Interface-2 Static logging::"+str);

    }
}
