package java8.lamda.example;

import java.util.stream.IntStream;

/**
 * Created by rohitkumar on 24/01/17.
 */
public class Sample1 {

    public static void main(String[] args) {

        /*System.out.println(isPrime(10));
        System.out.println(isPrime(9));
        System.out.println(isPrime(7));
        System.out.println(isPrime(29));*/

        System.out.println(isPrimeLambda(10));
        System.out.println(isPrimeLambda(9));
        System.out.println(isPrimeLambda(7));
        System.out.println(isPrimeLambda(29));
    }

    /**
     * This is imperative style of programming.
     * Because we are using statements/commands for the computer to perform.
     *
     * Here we are focusing on Iteration / infrastructure rather focusing on the problem..
     *
     * Here we are saying "What to do and how to do"
     *
     * Mutability
     *
     * @param number
     * @return
     */
    private static boolean isPrime(int number) {

        for (int i=2 ; i<=number/2; i++) {
            if(number % i == 0)
                return false;
        }

        return number > 1;
    }

    /**
     * This is Declarative Style of Programming.
     *
     * Here we took the focus away from the iteration and
     * our solution is reading more like the problem statement.
     *
     * Here we are saying "What to do and let the code handle how to do"
     *
     * Immutability
     *
     * @param number
     * @return
     */
    public static boolean isPrimeLambda(int number) {

        return number > 1 &&
                IntStream.range(2, number)
                .noneMatch(index -> number % index == 0);
    }
}
