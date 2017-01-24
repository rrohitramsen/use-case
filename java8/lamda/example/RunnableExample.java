package java8.lamda.example;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class RunnableExample {

    public static void main(String[] args) {

        Runnable r1 = () -> System.out.println("Rohit");
    }
}

class MyRunnnable implements Runnable {

    @Override
    public void run() {

    }
}