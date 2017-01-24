package java8.lamda.example;

import java8.defaultmethod.example.Interface1;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class Sample2 {

    public static void main(String[] args) {

        /*System.out.println(isPrimeLambda(10));
        System.out.println(isPrimeLambda(9));
        System.out.println(isPrimeLambda(7));
        System.out.println(isPrimeLambda(29));*/

       /* System.out.println(isPrimeLambdaPredicate(10));
        System.out.println(isPrimeLambdaPredicate(9));
        System.out.println(isPrimeLambdaPredicate(7));
        System.out.println(isPrimeLambdaPredicate(29));*/

        System.out.println(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        });

        Sample2 sample2 = new Sample2();
        sample2.test();
        //Runnable myRunnable = () -> System.out.println(this);

        MyInterface myInterface = ()->null;
        System.out.println(myInterface.display().display());

    }

    public void test() {
        Runnable myRunnable = () -> System.out.println(this);
        //myRunnable.run();
    }
    /**
     * Lets build up from this.. here we are not communicating properly.
     * Our code must read like a "Story not like a Puzzle".
     *
     * Here we can replace [ index -> number % index == 0 ] with the predicate.
     *
     * @param number
     * @return
     */
    public static boolean isPrimeLambda(int number) {

        return number > 1 &&
                IntStream.range(2, number / 2)
                        .noneMatch(index -> number % index == 0);
    }

    /**
     *
     * @param number
     * @return
     */
    public static boolean isPrimeLambdaPredicate(int number) {

        //Here divisor is parameter coming in this lambda expression.
        IntPredicate isDivisible = divisor -> number % divisor == 0;

        return (number > 1) &&
                IntStream.range(2, number / 2)
                        .noneMatch(isDivisible);
    }


    @FunctionalInterface
    interface MyInterface {

        MyInterface display();
    }

}
