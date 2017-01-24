package java8.defaultmethod.example;

/**
 * Created by rohitkumar on 24/01/17.
 */
public interface Interface1 {

    void method1(String str);

    default void log(String str) {
         method1("");
        System.out.println("Interface-1 logging::"+str);
    }

    static void logStatic(String str) {
        System.out.println("Interface-1 Static logging::"+str);

    }
}
