package java8.lamda.example;

import java8.defaultmethod.example.Interface2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by rohitkumar on 24/01/17.
 *
 * Problem : Find the double of the first even number greater then 3.
 */
public class Sample3 {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9);

        //System.out.println("Imperative Solution = "+imperativeSolution(values));

        //System.out.println("Declarative Solution = "+functionalSolution(values));

        //System.out.println("Declarative Solution = "+functionalSolutionMethodReference(values));

        //System.out.println("Declarative Solution = "+functionalSolutionMethodReferenceLazy(values));

        /*final Stream<Integer> action = functionalSolutionMethodReferenceLazy(values);
        Objects.requireNonNull(action, "Object is null");
        System.out.println(action.findFirst().get());*/

        System.out.println("Declarative Solution = "+functionalSolutionPredicate(values));

        //System.out.println("Declarative Solution = "+functionalSolutionFunction(values));

    }

    /**
     * There is problem in this code.
     * @param values
     * @return
     */
    public static int imperativeSolution(List<Integer> values) {

        int result = 0;
        for (int value : values) {
            if (value > 3 && value % 2 == 0) {
                result = value * 2;
                break;
            }
        }
        return result;
    }

    /**
     * Problem : Find the double of the first even number greater then 3.
     * @param values
     * @return
     */

    public static int functionalSolution(List<Integer> values) {

        return values.stream() // Stream is new Iterator in Java-8
                .filter(value -> value > 3)
                .filter(value -> value % 2 == 0)
                .map(value -> value * 2)
                .findFirst()
                .get();
    }

    /**
     * Method Reference in Java - 8,
     * A method reference is the shorthand syntax for a lambda expression that executes just ONE method.
     *
     * object :: methodName
     *
     * for static method, class :: methodName
     * Code must read like a problem statement or requirement.
     * @param values
     * @return
     */
    public static int functionalSolutionMethodReference(List<Integer> values) {

        //Here we are using Higher Order Function,
        //Lazy valuation and compositions.
        //Sample3 sample3 = new Sample3();
        return values.stream() // Stream is new Iterator in Java-8
                .filter(Sample3::isGreaterThan3)
                .filter(Sample3::isEvenNumber)
                .map(Sample3::doubleIt)
                .findFirst()
                .get();
    }

    public static boolean isGreaterThan3(int value) {
        System.out.println(" isGreaterThan3 = "+value);
        return value > 3;
    }

    public static boolean isEvenNumber(int value) {
        System.out.println(" isEvenNumber = "+value);
        return value % 2 == 0;
    }

    private static int doubleIt(int value) {
        System.out.println(" doubleIt = "+value);
        return value * 2;
    }

    /**
     * Lazy Intialization Explained
     *
     * @param values
     * @return
     */

    public static Stream<Integer>  functionalSolutionMethodReferenceLazy(List<Integer> values) {

        //Here we are using Higher Order Function,
        //Lazy valuation and compositions.
        System.out.println("LAZY LOADING");
         final Stream<Integer> action  = values.stream() // Stream is new Iterator in Java-8
                .filter(Sample3 :: isGreaterThan3)
                .filter(Sample3 :: isEvenNumber)
                .map(Sample3 :: doubleIt);
        return action;
        //System.out.println(action.findFirst().get());
    }

    /**
     * We can also use Predicate.
     * @param values
     * @return
     */
    public static int functionalSolutionPredicate(List<Integer> values) {

        Predicate<Integer> isGreaterThan3 = number -> number > 3;
        Predicate<Integer> isEven = number -> number % 2 == 0;

        return values.stream() // Stream is new Iterator in Java-8
                .filter(isGreaterThan3)
                .filter(isEven)
                .map(Sample3 :: doubleIt)
                .findFirst()
                .get();
    }

    /**
     *
     * @param values
     * @return
     */
    public static int functionalSolutionFunction(List<Integer> values) {

        Predicate<Integer> isGreaterThan3 = number -> number > 3;
        Predicate<Integer> isEven = number -> number % 2 == 0;

        //Function<Integer, Predicate<Predicate<Predicate<Integer>>>> pred =

        /**
         * Function here takes pivot as a input and return Predicate<Integer> as output.
         */
        Function<Integer, Predicate<Integer>> isGreaterThan = pivot ->
                number -> number > pivot;

        return values.stream() // Stream is new Iterator in Java-8
                .filter(isGreaterThan.apply(3))
                .filter(isEven)
                .map(Sample3 :: doubleIt)
                .findFirst()
                .get();
    }

}
